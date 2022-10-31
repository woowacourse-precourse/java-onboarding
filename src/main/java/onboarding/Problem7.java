package onboarding;

import java.util.*;

public class Problem7 {
    static class Node implements Comparable<Node>{
        String name;
        int point;

        public Node(String name, int point) {
            this.name = name;
            this.point = point;
        }

        @Override
        public int compareTo(Node o) {
            if(this.point != o.point){
                return o.point - this.point;
            }else{
                return name.compareTo(o.name);
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Set<String> userFriends = makeUserFriendsSet(user, friends);

        Map<String, Integer> pointMap = new HashMap<>();

        for (List<String> friend : friends) {
            String A = friend.get(0);
            String B = friend.get(1);

            if(A.equals(user) || B.equals(user)){
                continue;
            }

            if (userFriends.contains(A) && !userFriends.contains(B)) {
                pointMap.put(B, pointMap.getOrDefault(B, 0) + 10);
            } else if (!userFriends.contains(A) && userFriends.contains(B)) {
                pointMap.put(A, pointMap.getOrDefault(A, 0) + 10);
            }
        }

        for (String visitor : visitors) {
            if (!visitor.equals(user) && !userFriends.contains(visitor)) {
                pointMap.put(visitor, pointMap.getOrDefault(visitor, 0) + 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> entry : pointMap.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        for(int i = 0; i < 5; i++){
            if(pq.isEmpty()){
                break;
            }
            Node cur = pq.poll();
            answer.add(cur.name);
        }

        return answer;
    }
    static Set<String> makeUserFriendsSet(String user, List<List<String>> friends){
        Set<String> userFriends = new HashSet<>();

        for (List<String> cur : friends) {
            String A = cur.get(0);
            String B = cur.get(1);

            if (A.equals(user)) {
                userFriends.add(B);
            } else if (B.equals(user)) {
                userFriends.add(A);
            }
        }

        return userFriends;
    }
}
