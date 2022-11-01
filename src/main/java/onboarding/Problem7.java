package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, Integer> scoreMap = new HashMap<>();
    static Set<String> userFriend = new HashSet<>();
    static PriorityQueue<Friend> pq = new PriorityQueue<>();
    static List<String> answer = new ArrayList<>();

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = new ArrayList<>();
        List<String> friends_in1 = new ArrayList<>();
        friends_in1.add("donut");
        friends_in1.add("andole");
        List<String> friends_in2 = new ArrayList<>();
        friends_in2.add("donut");
        friends_in2.add("jun");
        List<String> friends_in3 = new ArrayList<>();
        friends_in3.add("donut");
        friends_in3.add("mrko");
        List<String> friends_in4 = new ArrayList<>();
        friends_in4.add("shakevan");
        friends_in4.add("andole");
        List<String> friends_in5 = new ArrayList<>();
        friends_in5.add("shakevan");
        friends_in5.add("jun");
        List<String> friends_in6 = new ArrayList<>();
        friends_in6.add("shakevan");
        friends_in6.add("mrko");
        friends.add(friends_in1);
        friends.add(friends_in2);
        friends.add(friends_in3);
        friends.add(friends_in4);
        friends.add(friends_in5);
        friends.add(friends_in6);
        List<String> visitors = new ArrayList<>();
        visitors.add("bedi");
        visitors.add("bedi");
        visitors.add("donut");
        visitors.add("bedi");
        visitors.add("shakevan");
        System.out.println(solution(user, friends, visitors));
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        updateFriend(user, friends);
        updateScore(friends);
        updateVisitor(visitors);
        scoreMap.remove(user);
        returnAnswer();

        return answer;
    }

    private static void returnAnswer() {

        for (String next : scoreMap.keySet()) {
            if (!userFriend.contains(next)) {
                pq.add(new Friend(next, scoreMap.get(next)));
            }
        }

        while (!pq.isEmpty()) {
            Friend friend = pq.poll();

            if (answer.size() > 5) {
                break;
            }

            if (friend.point > 0) {
                answer.add(friend.name);
            } else {
                break;
            }
        }
    }


    private static void updateVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            } else {
                scoreMap.put(visitor, 1);
            }
        }
    }

    private static void updateScore(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (userFriend.contains(friend1)) {
                scoreMap.put(friend2, scoreMap.get(friend2) + 10);
            }

            if (userFriend.contains(friend2)) {
                scoreMap.put(friend1, scoreMap.get(friend2) + 10);
            }
        }
    }

    private static void updateFriend(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            scoreMap.put(friend1, 0);
            scoreMap.put(friend2, 0);

            if (friend1.equals(user)) {
                userFriend.add(friend2);
            }

            if (friend2.equals(user)) {
                userFriend.add(friend1);
            }
        }
    }

    static class Friend implements Comparable<Friend> {
        String name;
        int point;

        public Friend(String name, int point) {
            this.name = name;
            this.point = point;
        }

        @Override
        public int compareTo(Friend o) {
            if (o.point > this.point) {
                return 1;
            } else if (o.point < this.point) {
                return -1;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}


