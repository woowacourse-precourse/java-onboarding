package onboarding;

import java.util.*;

public class Problem7 {

    static class User implements Comparable<User> {
        private String name;
        private int score;
        public User(String name, int score) {
            this.name = name;
            this.score = score;
        }
        public String getName() {
            return name;
        }
        public int getScore() {
            return score;
        }
        @Override
        public int compareTo(User o) {
            if (score == o.score) {
                return name.compareTo(o.name);
            }
            return o.score - score;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, Set<String>> friendInfoMap = getFriendInfoMap(friends);

        Set<String> userFriendSet = friendInfoMap.get(user);
        for (String s : friendInfoMap.keySet()) {
            if (s.equals(user)) continue;
            int score = 0;
            Set<String> friendSet = friendInfoMap.get(s);
            for (String friend : friendSet) {
                if (userFriendSet.contains(friend)) {
                    score += 10;
                }
            }
            scoreMap.put(s, score);
        }
        for (String visitor : visitors) {
            if (scoreMap.containsKey(visitor)) {
                scoreMap.replace(visitor, scoreMap.get(visitor)+1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }

        List<String> answer = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        for (String s : scoreMap.keySet()) {
            if (userFriendSet.contains(s)) continue;
            userList.add(new User(s, scoreMap.get(s)));
        }
        Collections.sort(userList);
        for (User otherUser : userList) {
            answer.add(otherUser.getName());
        }
        return answer;
    }

    static Map<String, Set<String>> getFriendInfoMap(List<List<String>> friends) {
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> friend : friends) {
            String friend1 = friend.get(0), friend2 = friend.get(1);
            if (!map.containsKey(friend1)) {
                map.put(friend1, new HashSet<>());
            }
            map.get(friend1).add(friend2);
            if (!map.containsKey(friend2)) {
                map.put(friend2, new HashSet<>());
            }
            map.get(friend2).add(friend1);
        }
        return map;
    }
}
