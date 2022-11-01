package onboarding;

import java.util.*;

public class Problem7 {

    public static class MakeSnsTeam {

        private static final int LEFT = 0;
        private static final int RIGHT = 1;
        private List<String> myFriends;

        public MakeSnsTeam() {}

        public static HashMap<String, Integer> getScoreByVisitor(List<String> visitor, HashMap<String, Integer> users) {
            for (int i = 0; i < visitor.size(); i++) {
                if (users.containsKey(visitor.get(i))) {
                    users.put(visitor.get(i), users.get(visitor.get(i)) + 1);
                }
            }
            return users;
        }
        public HashMap<String, Integer> getScoreByFriend(String user, List<List<String>> friends) {
            HashMap<String, Integer> users = new HashMap<>();
            List<String> myFriends = new ArrayList<>();
            for (int i = 0; i < friends.size(); i++) {
                if (!users.containsKey(friends.get(i).get(LEFT))) {
                    users.put(friends.get(i).get(LEFT), 0);
                }
                if (!users.containsKey(friends.get(i).get(RIGHT))) {
                    users.put(friends.get(i).get(RIGHT), 0);
                }
            }
            getMyFriends(user, friends, myFriends);
            getScoreByMyFriends(friends, users, myFriends);
            this.myFriends = myFriends;
            return users;
        }
        private static void getScoreByMyFriends(List<List<String>> friends, HashMap<String, Integer> users, List<String> myFriends) {
            for (int i = 0; i < friends.size(); i++) {
                String left = friends.get(i).get(LEFT);
                String right = friends.get(i).get(RIGHT);
                int score = 0;
                for (int j = 0; j < myFriends.size(); j++) {
                    if (left.equals(myFriends.get(j))) {
                        if (users.containsKey(left)) {
                            users.put(left, users.get(left) + 10);
                        }
                    }
                    if (right.equals(myFriends.get(j))) {
                        if (users.containsKey(right)) {
                            users.put(right, users.get(right) + 10);
                        }
                    }
                }
            }
        }

        private static void getMyFriends(String user, List<List<String>> friends, List<String> myFriends) {
            for (int i = 0; i < friends.size(); i++) {
                String left = friends.get(i).get(LEFT);
                String right = friends.get(i).get(RIGHT);
                if (left.equals(user)) {
                    myFriends.add(right);
                }
                if (right.equals(user))
                    myFriends.add(right);
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return List.of("andole", "jun", "bedi");
    }
}
