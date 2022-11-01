package onboarding;

import ExceptionValidation.P7ExceptionValidation;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        if (!(P7ExceptionValidation.p7ExceptionValidation(user, friends, visitors))) {
            return Collections.emptyList();
        }

        HashMap<String, ArrayList<Node>> graph;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost != b.cost ? b.cost - a.cost : a.v.compareTo(b.v));
        List<String> answer = new ArrayList<>();

        graph = initializeGraph(friends);

        HashMap<String, Integer> dist = dijkstra(user, graph);

        HashMap<String, Integer> scoreBoard = calculateScore(visitors, dist, graph, user);

        for (String userName : scoreBoard.keySet()) {
            pq.add(new Node(userName, scoreBoard.get(userName)));
        }

        int cnt = 0;
        while (!pq.isEmpty() && cnt <= 5) {
            Node v = pq.poll();
            if (dist.containsKey(v.v) && dist.get(v.v) == 1) {
                continue;
            }
            answer.add(v.v);
            cnt += 1;
        }

        return answer;

    }

    private static class Node {
        String v;
        int cost;

        public Node(String v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.v;
        }
    }

    public static HashMap<String, ArrayList<Node>> initializeGraph(List<List<String>> friends) {
        HashMap<String, ArrayList<Node>> graph = new HashMap<>();


        for (List<String> edge : friends) {

            ArrayList<Node> ls = new ArrayList<>();

            String a = edge.get(0);
            String b = edge.get(1);

            if (graph.containsKey(a)) {
                ls = graph.get(a);
                ls.add(new Node(b, 1));
            } else {
                ls.add(new Node(b, 1));
            }

            graph.put(a, ls);

            ls = new ArrayList<>();

            if (graph.containsKey(b)) {
                ls = graph.get(b);
                ls.add(new Node(a, 1));
            } else {
                ls.add(new Node(a, 1));
            }


            graph.put(b, ls);

        }

        return graph;
    }

    public static HashMap<String, Integer> dijkstra(String start, HashMap<String, ArrayList<Node>> graph) {

        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        HashMap<String, Integer> dist = new HashMap<>();


        for (String key : graph.keySet()) {
            dist.put(key, Integer.MAX_VALUE);
        }
        q.add(new Node(start, 0));
        dist.put(start, 0);

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (dist.get(current.v) < current.cost) {
                continue;
            }

            ArrayList<Node> adjacentList = graph.get(current.v);
            for (Node next : adjacentList) {
                if (current.cost + next.cost < dist.get(next.v)) {
                    dist.put(next.v, current.cost + next.cost);
                    q.add(new Node(next.v, current.cost + next.cost));
                }
            }

        }

        return dist;
    }

    public static HashMap<String, Integer> calculateScore(List<String> visitors, HashMap<String, Integer> dist, HashMap<String, ArrayList<Node>> graph, String user) {
        HashMap<String, Integer> score = new HashMap<>();


        for (String userName : dist.keySet()) {
            int mutualFriendCnt = 0;

            if (dist.get(userName) == 2) {
                for (Node friend : graph.get(user))
                    for (Node AdjacentFriend : graph.get(userName))
                        if (friend.v.equals(AdjacentFriend.v)) {
                            mutualFriendCnt += 1;
                        }
                score.put(userName, mutualFriendCnt * 10);
            }
        }

        for (String visitor : visitors) {
            if (score.containsKey(visitor)) {
                score.put(visitor, score.get(visitor) + 1);
            } else {
                score.put(visitor, 1);
            }
        }

        return score;
    }


}
