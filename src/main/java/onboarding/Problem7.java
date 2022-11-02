package onboarding;


import java.util.*;

public class Problem7 {
    static class Friend implements Comparable<Friend>{
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
            } else{
                return this.name.compareTo(o.name);
            }
        }
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> userFriend = new HashSet<>();
        Map<String, Integer> scoreMap = new HashMap<>();
        PriorityQueue<Friend> pq = new PriorityQueue<>();

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

        for (String visitor : visitors) {
            if (scoreMap.containsKey(visitor)) {
                scoreMap.put(visitor, scoreMap.get(visitor) + 1);
            } else{
                scoreMap.put(visitor, 1);
            }
        }

        scoreMap.remove(user);

        for (Map.Entry<String, Integer> entry : scoreMap.entrySet()) {
            if(!userFriend.contains(entry.getKey())) {
                pq.offer(new Friend(entry.getKey(), entry.getValue()));
            }
        }

        while (!pq.isEmpty()) {
            Friend friend = pq.poll();

            if (answer.size() > 5) {
                break;
            }

            if (friend.point > 0) {
                answer.add(friend.name);
            } else{
                break;
            }
        }

        return answer;
    }
}