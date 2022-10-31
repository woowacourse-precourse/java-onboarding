package onboarding;

import java.util.*;
import java.util.function.Predicate;


public class Problem7 {


    /**
     * 사용자들의 정보를 다루기 위한 클래스 자료형
     */
    static class userInfo implements Comparable<userInfo> {

        private final String name;
        private final Set<String> friends;
        private int point;

        public String getName() {
            return name;
        }

        public Set<String> getFriends() {
            return friends;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public void plusPoint() {
            this.point++;
        }

        public void addFriends(String friendsName) {
            friends.add(friendsName);
        }

        public userInfo(String name, String friend) {
            this.name = name;
            friends = new HashSet<>();
            friends.add(friend);
            point = 0;
        }

        @Override
        public String toString() {
            return name + "::" + point + "::" + friends;
        }


        @Override
        public int compareTo(userInfo o) {
            if (o.point == this.point) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(o.point, this.point);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, userInfo> users = cleanUpData(friends); // 객체 Map을 만들어 반환
        friendInfriend(user, users);      //친구의 친구를 탐색
        selectVisitors(users, visitors);  //방문한 사람들을 탐색
        userSorted(users);                //요구사항에 맞게 정렬

        List<String> keySet = userSorted(users);

        return returnAnswer(keySet, users);
    }

    /**
     * 정렬된 리스트와 유저정보를 가지고 정답을 만들어 반환하는 메서드
     * Return answer list.
     *
     * @param keySet the key set
     * @param users  the users
     * @return the list
     */
    public static List<String> returnAnswer(List<String> keySet, Map<String, userInfo> users) {
        List<String> answer = new ArrayList<>();
        for (String key : keySet) {
            int point = users.get(key).getPoint();
            if (point > 0) {
                answer.add(users.get(key).getName());
            }
        }
        return answer;
    }

    /**
     * Map을 1:점수순 2:이름순으로 정렬한 키셋을 반환하는 메서드
     * User sorted list.
     *
     * @param users the users
     * @return the list
     */
    public static List<String> userSorted(Map<String, userInfo> users) {
        List<String> keySet = new ArrayList<>(users.keySet());
        keySet.sort(Comparator.comparing(users::get));
        return keySet;
    }

    /**
     * 방문자들을 비교해 점수를 증가시켜주는 메서드 친구가 아닌 경우 점수를 증가시켜주는 메서드
     * Select visitors map.
     *
     * @param users    the users
     * @param visitors the visitors
     */
    public static void selectVisitors(Map<String, userInfo> users, List<String> visitors) {
        for (String s : visitors) {
            if (!users.containsKey(s)) {
                users.put(s, new userInfo(s, ""));
                users.get(s).plusPoint();
            }
        }
    }

    /**
     * 본인의 친구 목록을 가지고 다른 친구들의 친구들을 비교해 점수를 계산하는 메서드
     * Friend infriend map.
     *
     * @param user  the user
     * @param users the users
     */
    public static void friendInfriend(String user, Map<String, userInfo> users) {

        Set<String> myFreinds = users.get(user).getFriends();

        for (String key : users.keySet()) {
            if (key.equals(user)) continue;

            Set<String> friendsList = users.get(key).getFriends();
            int point = matchesName(myFreinds, friendsList);
            users.get(key).setPoint(point);
        }
    }

    /**
     * 사용자의 정보를 다루기 편하게 가공하는 메서드  [ 본인이름 : 친구목록 ]
     * Clean up data map.
     *
     * @param friends the friends
     * @return the map
     */
    public static Map<String, userInfo> cleanUpData(List<List<String>> friends) {
        Map<String, userInfo> users = new HashMap<>();
        for (List<String> list : friends) {
            String nameA = list.get(0);
            String nameB = list.get(1);

            if (!users.containsKey(nameA)) users.put(nameA, new userInfo(nameA, nameB));
            else users.get(nameA).addFriends(nameB);
            if (!users.containsKey(nameB)) users.put(nameB, new userInfo(nameB, nameA));
            else users.get(nameB).addFriends(nameA);
        }
        return users;
    }

    /**
     * 두 사람의 친구들이 일치하는지 확인하는 메서드
     * Matchs name int.
     *
     * @param myFreinds   the my freinds
     * @param friendsList the friends list
     * @return the int
     */
    public static int matchesName(Set<String> myFreinds, Set<String> friendsList) {
        long result = myFreinds.stream()
                .filter(old -> friendsList.stream()
                        .anyMatch(Predicate.isEqual(old))).count();

        long point = result * 10;

        return (int) point;
    }

}
