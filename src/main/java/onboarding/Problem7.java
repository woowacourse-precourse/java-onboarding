package onboarding;

import java.util.*;

public class Problem7 {


    static HashMap<String, Set<String>> friendsHashMap = new HashMap<>();
    static HashMap<String, Integer> points = new HashMap<>();

    static void calcFriends(String user) {
        Set<String> userFriendSet = friendsHashMap.get(user);
        for (Map.Entry<String, Integer> key : points.entrySet()) {

            int currentScore = 0;
            Set<String> currentFriendSet = friendsHashMap.get(key.getKey());

            for (String userFriendName : userFriendSet) {
                if (currentFriendSet.contains(userFriendName)) {
                    currentScore += 10;
                }
            }
            key.setValue(currentScore);
        }
    }

    static void calcVisitors(List<String> visitors) {
        visitors.forEach(s -> {
            if(points.containsKey(s)){
                points.put(s, points.get(s) + 1);
            }else{
                points.put(s, 1);
            }
        });
    }

    static class RecFriend {
        private String name;
        private Integer score;

        RecFriend(String name, Integer score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getScore() {
            return score;
        }

    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friends.forEach(f -> {
            if (!f.get(0).equals(user)) points.put(f.get(0), 0);
            if (!f.get(1).equals(user)) points.put(f.get(1), 0);
            if (!friendsHashMap.containsKey(f.get(0))) {
                friendsHashMap.put(f.get(0), new HashSet<>());
            }
            if (!friendsHashMap.containsKey(f.get(1))) {
                friendsHashMap.put(f.get(1), new HashSet<>());
            }
            friendsHashMap.get(f.get(0)).add(f.get(1));
            friendsHashMap.get(f.get(1)).add(f.get(0));
        });
        calcFriends(user);
        calcVisitors(visitors);
        List<RecFriend> recFriendList = new ArrayList<>();
        for (String name : points.keySet()) {
            if (points.get(name) == 0) continue;
            if (friendsHashMap.get(user).contains(name)) continue;
            recFriendList.add(new RecFriend(name, points.get(name)));
        }


        Collections.sort(recFriendList, (a, b) -> {

            if (!a.getScore().equals(b.getScore())) {
                return -Integer.compare(a.getScore(), b.getScore());
            }
            return String.CASE_INSENSITIVE_ORDER.compare(a.getName(), b.getName());
        });
        System.out.println(recFriendList);

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < Integer.min(recFriendList.size(), 5); i++) {
            answer.add(recFriendList.get(i).name);
        }

        return answer;
    }
}
