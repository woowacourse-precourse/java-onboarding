package onboarding;

import java.util.*;

/** 구현해야할 기능
 *  구조체 설계 User(이름, 친구 list)
 *  User 생성하기 (매개변수 : String 이름)
 *  User 친구 추가
 *  유저 기준으로 친구 탐색 후 점수 설정(이미 친구인 경우 0, 친구의 친구 10, 방문자 1 * n, 친구이면서 방문자 10 + 1 * n)
 *  탐색을 하기 위해 해시맵 사용 <String, User>
 *  점수를 저장하기 위한 arrayList 필요
 */
public class Problem7 {

    static Map<String, User> userMap = new HashMap<>();
    static List<String> userList = new ArrayList<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        createUser(user);

        for(int i = 0; i < friends.size(); i++) {
            String user1 = friends.get(i).get(0);
            String user2 = friends.get(i).get(1);

            createUser(user1);
            createUser(user2);
            addFriend(user1, user2);
            addFriend(user2, user1);
        }

        List<String> answer = calcScore(user, visitors);
        return answer;
    }

    public static void createUser(String userName){
        if(userMap.containsKey(userName))
            return;

        User user = new User();
        user.name = userName;
        userMap.put(userName, user);
        userList.add(userName);
    }
    public static void addFriend(String userName, String friendName) {
        User user = userMap.get(userName);

        if(!user.friends.contains(friendName))
            user.friends.add(friendName);
    }

    /**
     * 우선 자신의 친구 목록에 있는지 확인
     * 자신의 친구 목록에 해당하는 User가 존재한다면 0점
     * 없다면 내 친구의 친구 목록을 탐색하여(내 친구의 친구 목록까지만 확인하면 됨) 있는지 확인 있다면 10점 * n
     * 위에서도 없다면 방문자 목록에 있는 사람들은 1점 * n
     */
    public static List<String> calcScore(String userName, List<String> visitors) {
        List<UserForScore> ufsList = initUFSList();
        User user = userMap.get(userName);
        for(int i = 0;  i< ufsList.size(); i++) {
            UserForScore ufs = ufsList.get(i);
            if(ufs.name.equals(userName))  //자기 자신일 경우
                ufs.score = -1;
            else if(user.friends.contains(ufs.name)) // 자신의 친구일 경우 0점
                ufs.score =0;
            else {  // 친구의 친구일 경우
                int count = confirmFriendOfFriend(userName, ufs.name);
                for(int j = 0 ; j < count; j++)
                    ufs.score += 10;
            }
        }

        for(int i = 0; i< visitors.size(); i++) {
            // 자신의 친구 일 경우 0
            if (user.friends.contains(visitors.get(i)))
                continue;
                // 친구의 친구 인 경우 +1
            else if (confirmFriendOfFriend(userName, visitors.get(i)) !=0) {
                for (int j = 0; j < ufsList.size(); j++) {
                    if (ufsList.get(j).name.equals(visitors.get(i))) {
                        ufsList.get(j).score++;
                        break;
                    }
                }
            }
            // 친구의 친구에도 관련이 없는 경우 +1
            else {
                if (ufsList.contains(new UserForScore(visitors.get(i)))) {
                    for (int j = 0; j < ufsList.size(); j++) {
                        if (ufsList.get(j).name.equals(visitors.get(i))) {
                            ufsList.get(j).score++;
                            break;
                        }
                    }
                }
                else {
                    UserForScore ufs =new UserForScore(visitors.get(i));
                    ufs.score++;
                    ufsList.add(ufs);
                }
            }
        }

        Collections.sort(ufsList);  //ufs의 compareTo 메서드를 활용해서 정렬 (숫자 내림차순, 숫자 같을시에 이름 순)
        List<String> result = new ArrayList<>();

        for(int i = 0; i< 5; i++) {
            if(ufsList.get(i).name.equals(userName))
                continue;
            if(ufsList.get(i).score <= 0)
                break;
            else
                result.add(ufsList.get(i).name);
        }

        return result;
    }

    // result가 0인 경우 찾고자 하는 유저를 알고 있는 친구는 없다. 그 이상일 경우 result의 값은 해당 유저를 알고있는 친구의 수를 말한다.
    public static int confirmFriendOfFriend(String userName, String whoName) {
        int result = 0;
        User user = userMap.get(userName);
        for(int i = 0; i< user.friends.size(); i++) {
            User userFriend = userMap.get(user.friends.get(i));
            if(userFriend.friends.contains(whoName))
                result++;
        }
        return result;
    }

    public static List<UserForScore> initUFSList () {
        List<UserForScore> ufsList = new ArrayList<>();
        for(int i = 0; i< userList.size(); i++) {
            UserForScore ufs = new UserForScore(userList.get(i));
            ufsList.add(ufs);
        }
        return ufsList;
    }
    public static class User {
        String name;
        ArrayList<String> friends = new ArrayList<>();
    }
    public static class UserForScore implements Comparable<UserForScore>{
        String name;
        int score;

        public UserForScore(String name) {
            this.name = name;
            score = 0;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
        @Override
        public int compareTo(UserForScore o) {
            if(this.score != o.getScore())
                return o.getScore() - this.score;
            return this.name.compareTo(o.getName());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserForScore that = (UserForScore) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
