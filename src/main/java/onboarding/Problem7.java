package onboarding;

import java.util.*;


public class Problem7 {

    static class Friend implements Comparable<Friend> {
        String name;
        int score;

        public Friend(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Friend o) {
            if (this.score == o.score) {
                return this.name.compareTo(o.name);
            }
            return Integer.compare(o.score, this.score);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        HashSet<String> friendSet = new HashSet<>();
        friendSet.add(user);
        for (List<String> relation : friends) {
            if (relation.get(0).equals(user) || relation.get(1).equals(user)) {
                friendSet.add(relation.get(0).equals(user) ? relation.get(1) : relation.get(0));
            }
        }

        for (List<String> relation : friends) {
            if (friendSet.contains(relation.get(0)) && !friendSet.contains(relation.get(1))) {
                scoreBoard.put(relation.get(1), scoreBoard.getOrDefault(relation.get(1), 0) + 10);
            } else if (friendSet.contains(relation.get(1)) && !friendSet.contains(relation.get(0))) {
                scoreBoard.put(relation.get(0), scoreBoard.getOrDefault(relation.get(0), 0) + 10);
            }
        }

        for (String visitor : visitors) {
            if (!friendSet.contains(visitor)) {
                scoreBoard.put(visitor, scoreBoard.getOrDefault(visitor, 0) + 1);
            }
        }

        ArrayList<Friend> friendList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scoreBoard.entrySet()) {
            friendList.add(new Friend(entry.getKey(), entry.getValue()));
        }
        Collections.sort(friendList);

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < Math.min(5, friendList.size()); i++) {
            answer.add(friendList.get(i).name);
        }
        return answer;
    }
}
