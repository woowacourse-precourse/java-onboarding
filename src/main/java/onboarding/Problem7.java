package onboarding;


import java.util.*;

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

        public boolean isNotMyFriend(String user) {
            return !this.getMyFriends().contains(user);
        }

        public void addScore(int score) {
            this.score += score;
        }

        public void addMyFriend(String friend) {
            this.myFriends.add(friend);
        }

        public String getName() {
            return name;
        }

        public List<String> getMyFriends() {
            return myFriends;
        }
    }

    static List<Friend> friends = new ArrayList<>();
    static Map<String, Integer> numberOfFriends = new HashMap<>();
    static final int ACQUAINTANCE_SCORE = 10;
    static final int VISITANT_SCORE = 1;

    public static List<String> solution(String user, List<List<String>> friendships, List<String> visitors) {
        init(friendships, visitors);
        updateScores(user);

        return getAnswer(user);
    }

    private static void updateScores(String user) {
        for (int i = 0; i < friends.size(); i++) {
            if (i != numberOfFriends.get(user)) {
                addScore(user, i);
            }
        }

        Collections.sort(friends);
    }

    private static void addScore(String user, int index) {
        List<String> userFriends = getFriend(user).getMyFriends();
        Friend friend = friends.get(index);
        List<String> myFriends = friend.getMyFriends();

        for (String userFriend : userFriends) {
            if (myFriends.contains(userFriend)) {
                friend.addScore(ACQUAINTANCE_SCORE);
            }
        }
    }

    private static void init(List<List<String>> friendships, List<String> visitors) {
        int idx = 0;
        for (List<String> friend : friendships) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (isNotContainMap(friendA)) {
                initFriend(idx++, friendA);
            }

            if (isNotContainMap(friendB)) {
                initFriend(idx++, friendB);
            }

            addMyFriend(friendA, friendB);
            addMyFriend(friendB, friendA);
        }

        for (String visitor : visitors) {
            if (isNotContainMap(visitor)) {
                initFriend(idx++, visitor);
            }

            getFriend(visitor).addScore(VISITANT_SCORE);
        }
    }

    private static boolean isNotContainMap(String friend) {
        return !numberOfFriends.containsKey(friend);
    }

    private static void initFriend(int idx, String friend) {
        numberOfFriends.put(friend, idx);
        friends.add(idx, new Friend(friend, 0));
    }

    private static void addMyFriend(String friendA, String friendB) {
        getFriend(friendA).addMyFriend(friendB);
    }

    private static Friend getFriend(String user) {
        return friends.get(numberOfFriends.get(user));
    }

    private static List<String> getAnswer(String user) {
        List<String> answer = new ArrayList<>();
        int count = 0;
        for (Friend friend : friends) {
            if (friend.isNotMyFriend(user) && friend.score != 0) {
                if (count < 5) {
                    answer.add(friend.name);
                    count++;
                }
            }
        }
        return answer;
    }
}
