package onboarding;


import java.util.*;
import java.util.stream.Collectors;

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

    public static List<String> solution(String user, List<List<String>> friendships, List<String> visitors) {
        List<Friend> friends = new ArrayList<>();
        Map<String, Integer> numberOfFriends = new HashMap<>();

        init(friendships, visitors, numberOfFriends, friends);

        for (int i = 0; i < friends.size(); i++) {
            if (i != numberOfFriends.get(user)) {
                addScore(numberOfFriends, friends, user, i);
            }
        }

        Collections.sort(friends);

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

    private static void addScore(Map<String, Integer> numberOfFriends, List<Friend> friends, String user, int index) {
        List<String> userFriends = friends.get(numberOfFriends.get(user)).getMyFriends();
        Friend friend = friends.get(index);
        List<String> myFriends = friend.getMyFriends();

        for (String userFriend : userFriends) {
            if (myFriends.contains(userFriend)) {
                friend.addScore(10);
            }
        }
    }

    private static void init(List<List<String>> friendships, List<String> visitors, Map<String, Integer> numberOfFriends, List<Friend> friends) {
        int idx = 0;
        for (List<String> friend : friendships) {
            String friendA = friend.get(0);
            String friendB = friend.get(1);

            if (isNotContainMap(numberOfFriends, friendA)) {
                initFriend(numberOfFriends, friends, idx++, friendA);
            }

            if (isNotContainMap(numberOfFriends, friendB)) {
                initFriend(numberOfFriends, friends, idx++, friendB);
            }

            addMyFriend(numberOfFriends, friends, friendA, friendB);
            addMyFriend(numberOfFriends, friends, friendB, friendA);
        }

        for (String visitor : visitors) {
            if (isNotContainMap(numberOfFriends, visitor)) {
                initFriend(numberOfFriends, friends, idx++, visitor);
            }

            friends.get(numberOfFriends.get(visitor)).addScore(1);
        }
    }

    private static boolean isNotContainMap(Map<String, Integer> numberOfFriends, String friend) {
        return !numberOfFriends.containsKey(friend);
    }

    private static void initFriend(Map<String, Integer> numberOfFriends, List<Friend> friends, int idx, String friend) {
        numberOfFriends.put(friend, idx);
        friends.add(idx, new Friend(friend, 0));
    }

    private static void addMyFriend(Map<String, Integer> numberOfFriends, List<Friend> friends, String friendA, String friendB) {
        friends.get(numberOfFriends.get(friendA)).addMyFriend(friendB);
    }
}
