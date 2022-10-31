package onboarding;

import java.util.*;

public class Problem7 {
    private static HashSet<String> userFriend;
    private static HashMap<String, Integer> friendList;
    private static PriorityQueue<ID> priorityRank;

    private static class ID implements Comparable<ID> {
        String name;
        int score;

        public ID (String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(ID o) {
            if (this.score == o.score) {
                return this.name.compareTo(o.name);
            }
            return (o.score - this.score);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        userFriend = new HashSet<>();
        friendList = new HashMap<>();
        priorityRank = new PriorityQueue<>();
        userFriend.add(user);

        for (List l : friends) {
            String s1 = (String) l.get(0);
            String s2 = (String) l.get(1);

            addFriendNetwork(user, s1, s2);

        }

        for (List l : friends) {
            String s1 = (String) l.get(0);
            String s2 = (String) l.get(1);

            plusScoreInFriends(s1, s2);
            plusScoreInFriends(s2, s1);
        }

        for (String s : visitors) {
            plusScoreInVisitors(s);
        }

        for (String s : friendList.keySet()) {
            priorityRank.offer(new ID(s, friendList.get(s)));
        }


        while (!priorityRank.isEmpty() && answer.size() < 5) {
            ID id = priorityRank.poll();
            int score = id.score;
            String name = id.name;
            if (score > 0) {
                answer.add(name);
            }
        }

        return answer;
    }

    private static void addFriendNetwork(String user, String firstPerson, String secondPerson) {
        if (firstPerson.equals(user)) {
            userFriend.add(secondPerson);
            return;
        }
        if (secondPerson.equals(user)) {
            userFriend.add(firstPerson);
            return;
        }
        if (!friendList.containsKey(firstPerson)) {
            friendList.put(firstPerson, 0);
        }
        if (!friendList.containsKey(secondPerson)) {
            friendList.put(secondPerson, 0);
        }
    }

    private static void plusScoreInFriends(String firstPerson, String secondPerson) {
        if (userFriend.contains(firstPerson) && !userFriend.contains(secondPerson)) {
            friendList.put(secondPerson, friendList.getOrDefault(secondPerson, 0) + 10);
        }
    }

    private static void plusScoreInVisitors(String visitor) {
        if (!userFriend.contains(visitor)) {
            friendList.put(visitor, friendList.getOrDefault(visitor, 0) + 1);
        }
    }
}