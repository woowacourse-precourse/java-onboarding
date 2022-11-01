package onboarding;

import java.util.*;

public class Problem7 {
    static class Info implements Comparable<Info> {
        private int score = 0;
        private String name;
        public Info(int score, String name) {
            super();
            this.score = score;
            this.name = name;
        }
        @Override
        public int compareTo(Info info) {
            if(score == info.score)
                return this.name.compareTo(info.name);
            else
                return Integer.compare(info.score, score);
        }
    }
    private static void inputFriend(String user1, String user2, Map<String, Set<String>> friendMap) {
        if(!friendMap.containsKey(user1)) friendMap.put(user1, new HashSet<>());
        if(user2 != null) friendMap.get(user1).add(user2);
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Map<String, Set<String>> friendMap = new HashMap<>();
        Map<String, Info> user2Info = new HashMap<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();

        for(List<String> friend: friends) {
            String user1 = friend.get(0), user2 = friend.get(1);
            inputFriend(user1, user2, friendMap);
            inputFriend(user2, user1, friendMap);

            if(!user2Info.containsKey(user1)) user2Info.put(user1, new Info(0, user1));
            if(!user2Info.containsKey(user2)) user2Info.put(user2, new Info(0, user2));
        }
        for(String visitor: visitors) {
            if(!user2Info.containsKey(visitor)) user2Info.put(visitor, new Info(1, visitor));
            else user2Info.get(visitor).score += 1;
            inputFriend(visitor, null, friendMap);
        }

        for(String target: friendMap.keySet()) {
            if(target.equals(user)) continue;

            Set<String> friendsOfUser = new HashSet<>(friendMap.get(user));
            Set<String> other = friendMap.get(target);
            friendsOfUser.retainAll(other);

            int intersection = friendsOfUser.size();
            user2Info.get(target).score += 10 * intersection;
            pq.add(user2Info.get(target));
        }

        while(!pq.isEmpty()) {
            Info curr = pq.poll();
            if(friendMap.get(user).contains(curr.name)) continue;
            if(curr.score != 0) answer.add(curr.name);
            else break;
        }

        return answer;
    }

    public static void main(String[] args) {
        List<List<String>> friends = new ArrayList<>();
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        friends.add(List.of("donut", "andole"));
        friends.add(List.of("donut", "jun"));
        friends.add(List.of("donut", "mrko"));
        friends.add(List.of("shakevan", "andole"));
        friends.add(List.of("shakevan", "jun"));
        friends.add(List.of("shakevan", "mrko"));

        System.out.println(solution("mrko", friends, visitors));
    }
}
