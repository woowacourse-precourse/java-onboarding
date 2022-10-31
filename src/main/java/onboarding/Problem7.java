package onboarding;

import java.util.*;

public class Problem7 {
    public static class Pair implements Comparable<Pair> {
        private final int first;
        private final String second;

        public Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) { // 우선순위 큐의 정렬을 위한 Comparable 인터페이스 오버라이딩한다
            if (first == o.first)
                return second.compareToIgnoreCase(o.second);
            return o.first - first; // 점수 내림차순, 이름 오름차순(사전순)
        }
    }

    public static void setRelation(Map<String, Set<String>> map, String a, String b) {
        // map에 a, b에 대한 Set에 각각 b, a를 추가한다
        if (!map.containsKey(a))
            map.put(a, new HashSet<>());
        map.get(a).add(b);

        if (!map.containsKey(b))
            map.put(b, new HashSet<>());
        map.get(b).add(a);
    }

    public static void evaluateScore(Map<String, Set<String>> map,
                                     Map<String, Integer> score,
                                     List<String> visitors,
                                     String user) {
        Set<String> userFriendSet = map.get(user);
        if (userFriendSet != null)
            map.forEach((member, memberFriendSet) -> {
                if (member.equals(user)) return; // 사용자 본인이라면 반복문을 실행하지 않는다

                for (String userFriend : userFriendSet) {
                    if (memberFriendSet.contains(userFriend)) {
                        score.put(member, score.getOrDefault(member, 0) + 10);
                    }
                }
            });

        for (String visitor : visitors) {
            score.put(visitor, score.getOrDefault(visitor, 0) + 1);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        Map<String, Set<String>> friendMap = new HashMap<>(); // 해당 user에 대한 친구들에 대한 Set
        Map<String, Integer> friendScore = new HashMap<>(); // 각 user에 대한 추천 점수
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(); // 점수에 따라 정렬하여 최대 5명을 반환하도록 우선순위 큐를 사용한다

        for (List<String> friendRelation : friends) {
            String friendA = friendRelation.get(0);
            String friendB = friendRelation.get(1);

            setRelation(friendMap, friendA, friendB);
        }

        evaluateScore(friendMap, friendScore, visitors, user);

        friendScore.forEach((k, v) -> {
            priorityQueue.add(new Pair(v, k)); // Pair 클래스를 이용해서 우선순위 큐 위에서 정렬한다
        });

        while (!priorityQueue.isEmpty() && answer.size() < 5) { // 큐에 원소가 있고 4개 이하만 골랐을 때
            if (priorityQueue.peek().first == 0) break; // "추천 점수가 0점인 경우 추천하지 않으며"

            if (!friendMap.containsKey(user) // 사용자의 친구 정보가 없으면 무조건 추천하고,
                    || !friendMap.get(user).contains(priorityQueue.peek().second)) // 이미 사용자와 친구인 경우는 추천하지 않는다
            {
                answer.add(priorityQueue.peek().second);
            }
            priorityQueue.poll();
        }

        return answer;
    }
}
