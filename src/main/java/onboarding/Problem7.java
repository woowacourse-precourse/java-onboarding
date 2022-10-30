package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Problem7 {

    static class Friend implements Comparable<Friend> {
        private String name;
        private int score;
        private List<String> myFriends;

        Friend (String name, int score) {
            this.name = name;
            this.score = score;
            myFriends = new ArrayList<>();
        }

        @Override
        public int compareTo(Friend o) {
            if (this.score == o.score) {
                return name.compareTo(o.name);
            }

            return o.score - score;
        }

        public void addScore(int score) {
            this.score += score;
        }

        public String getName() {
            return name;
        }

        public List<String> getMyFriends() {
            return myFriends;
        }
    }

    public static List<String> solution(String user, List<List<String>> friendships, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static void init(List<List<String>> friendships, List<String> visitors, Map<String, Integer> numberOfFriends, List<Friend> friends) {
        int idx = 0;
        for (List<String> friend : friendships) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (!numberOfFriends.containsKey(friendA)) {
                numberOfFriends.put(friendA, idx);
                friends.add(idx++, new Friend(friendA, 0));
            }

            if (!numberOfFriends.containsKey(friendB)) {
                numberOfFriends.put(friendB, idx);
                friends.add(idx++, new Friend(friendB, 0));
            }

            friends.get(numberOfFriends.get(friendA)).getMyFriends().add(friendB);
            friends.get(numberOfFriends.get(friendB)).getMyFriends().add(friendA);
        }

        for (String visitor : visitors) {
            if (!numberOfFriends.containsKey(visitor)) {
                numberOfFriends.put(visitor, idx);
                friends.add(idx++, new Friend(visitor, 0));
            }

            friends.get(numberOfFriends.get(visitor)).addScore(1);
        }
    }
}
