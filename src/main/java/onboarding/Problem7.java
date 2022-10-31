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

        public Node(String vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    // 그래프 초기화
    private static Map<String, ArrayList<Node>> initializeGraph(List<List<String>> friends) {
        Map<String, ArrayList<Node>> graph = new HashMap<>();

        for (List<String> relationship : friends) {
            String A = relationship.get(0);
            String B = relationship.get(1);

            addNodeToGraph(graph, A, B);
            addNodeToGraph(graph, B, A);
        }

        return graph;
    }

    private static void addNodeToGraph(Map<String, ArrayList<Node>> graph, String from, String to) {
        ArrayList<Node> list = new ArrayList<>();
        if(graph.containsKey(from)){
            list = graph.get(from);
            list.add(new Node(to, 1));
        }else{
            list.add(new Node(to, 1));
        }
        graph.put(from, list);
    }


    // 다익스트라 알고리즘
    private static Map<String, Integer> dijkstra(Map<String, ArrayList<Node>> graph, String start) {
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
