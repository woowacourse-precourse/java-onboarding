package onboarding;

import java.util.*;

public class Problem7 {

    static class User {
        private String nickName;
        private List<User> friends = new ArrayList<>();

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public List<User> getFriends() {
            return friends;
        }

        public void setFriends(User friend) {
            this.friends.add(friend);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> points = new HashMap<>();
        Map<String, User> users = new HashMap<>();
        Set<String> userSet = new HashSet<>();
        Set<String> currentUser = new HashSet<>();
        /*
        * 모든 유저 이름 저장
        * */
        for (List<String> friend : friends) {
            userSet.addAll(friend);
        }

        /*
        * 모든 유저 객체 생성
        * */
        for (String name : userSet) {
            User u = new User();
            u.setNickName(name);
            users.put(name, u);
        }

        /*
        * 유저간 친구관계 설정
        * */
        for (List<String> friend : friends) {
            String f1 = friend.get(0);
            String f2 = friend.get(1);
            if (f1.equals(user) || f2.equals(user)) {
                currentUser.add(f1);
                currentUser.add(f2);
            }
            users.get(f1).setFriends(users.get(f2));
            users.get(f2).setFriends(users.get(f1));
        }

        /*
        * 친구 추천 점수 계산
        * 단, 이미 친구 맺은 관계이면 제외
        * */
        for (User friend : users.get(user).getFriends()) {
            for (User f: friend.getFriends()) {
                if (currentUser.contains(f.getNickName())) {
                    continue;
                }
                if (points.get(f.getNickName()) == null && !f.getNickName().equals(user)) {
                    points.put(f.getNickName(), 10);
                } else if (points.get(f.getNickName()) != null && !f.getNickName().equals(user)){
                    points.put(f.getNickName(), points.get(f.getNickName())+10);
                }
            }
        }

        /*
        * 타임 라인 방문 점수 계산
        * 단, 이미 친구 맺은 관계이면 제외
        * */
        for (String visitor : visitors) {
            if (currentUser.contains(visitor)) {
                continue;
            }
            if (points.get(visitor) == null) {
                points.put(visitor, 1);
            } else {
                points.put(visitor, points.get(visitor)+1);
            }
        }

        /*
        * 점수 순으로 정렬
        * */
        List<String> keySet = new ArrayList<>(points.keySet());
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return points.get(o2).compareTo(points.get(o1));
            }
        });

        return keySet;
    }

}
