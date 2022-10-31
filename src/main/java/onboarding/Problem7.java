package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // 그래프의 노드 클래스 정의
    private static class Node implements Comparable<Node> {
        String vertex;
        int cost;

        public Node(String vertex,int cost){
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }


    // 다익스트라 알고리즘
    private Map<String, Integer> dijkstra(Map<String, ArrayList<Node>> graph, String start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<String, Integer> distance = new HashMap<>();
        Node pqNode;
        ArrayList<Node> adjacentNodes;

        for (String key : graph.keySet()) {
            distance.put(key, Integer.MAX_VALUE);
        }

        distance.put(start, 0);
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            pqNode = pq.poll();
            if (distance.get(pqNode.vertex) < pqNode.cost) {
                continue;
            }

            adjacentNodes = graph.get(pqNode.vertex);

            for (Node next : adjacentNodes) {
                int newCost = next.cost + pqNode.cost;

                if (newCost < distance.get(next.vertex)) {
                    distance.put(next.vertex, newCost);
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }

        return distance;
    }
}
