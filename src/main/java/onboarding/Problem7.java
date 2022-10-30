package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //TODO : 점수를 계산하기 위해서는 유저 이름과 스코어를 저장할 수 있는 자료구조가 필요하다.
        return null;
    }
    public static class User {
        String name;
        ArrayList<String> friends = new ArrayList<>();
    }
    public static class UserForScore {
        String name;
        int score;

        public UserForScore(String name) {
            this.name = name;
            score = 0;
        }
    }
}
