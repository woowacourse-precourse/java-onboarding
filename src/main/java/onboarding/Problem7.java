package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        Map<String, Integer> scoreBoard = new HashMap<>();
        Map<String, ArrayList<Node>> graph = initializeGraph(friends);
        Map<String, Integer> distance = dijkstra(graph, user);

        scoreMutual(user,distance,graph,scoreBoard);
        scoreVisitor(visitors, scoreBoard, distance);

        List<String> answer = aggregateBoard(scoreBoard);
        return answer;
    }

    // 결과 집계용 클래스
    private static class Stat implements Comparable<Stat>{
        String name;
        int score;

        public Stat(String name,int score) {
            this.name = name;
            this.score = score;
        }
        @Override
        public int compareTo(Stat s){
            if (this.score != s.score) {
                return s.score - this.score;
            }
            return this.name.compareTo(s.name);
        }
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

    // 그래프에 간선 추가
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

    // 함께 아는 친구 점수 부여
    private static void scoreMutual(String user, Map<String, Integer> distance, Map<String, ArrayList<Node>> graph, Map<String, Integer> board){
        for (String friend : distance.keySet()) {
            if (distance.get(friend) == 2) {
                if (board.containsKey(friend)) {
                    board.put(friend, board.get(friend) + countMutual(user, friend, graph) * 10);
                } else {
                    board.put(friend, countMutual(user, friend, graph) * 10);
                }
            }
        }
    }

    // 함께 아는 친구 카운트
    private static int countMutual(String user, String friend, Map<String, ArrayList<Node>> graph) {
        int cnt = 0;

        ArrayList<Node> userAdjacentList = graph.get(user);
        ArrayList<Node> friendAdjacentList = graph.get(friend);

        for (Node userAdjacent : userAdjacentList) {
            for (Node friendAdjacent : friendAdjacentList) {
                if (userAdjacent.vertex.equals(friendAdjacent.vertex)) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }

    // 방문자 점수 부여
    private static void scoreVisitor(List<String> visitors, Map<String, Integer> board,Map<String, Integer> distance) {
        for (String visitor : visitors) {
            if(distance.containsKey(visitor) && distance.get(visitor) == 1) continue;
            board.put(visitor, board.containsKey(visitor) ? board.get(visitor) + 1 : 1);
        }
    }

    // 상위 5명 반환
    private static List<String> aggregateBoard(Map<String, Integer> board) {
        PriorityQueue<Stat> scorePQ = new PriorityQueue<>();
        List<String> answer = new ArrayList<>();
        int cnt = 0;

        for (String name : board.keySet()) {
            scorePQ.add(new Stat(name, board.get(name)));
        }

        Stat topStat;

        while (!scorePQ.isEmpty() && cnt < 5) {
            topStat = scorePQ.poll();
            if (topStat.score == 0) {
                break;
            }
            answer.add(topStat.name);
            cnt ++;
        }

        return answer;
    }

}
