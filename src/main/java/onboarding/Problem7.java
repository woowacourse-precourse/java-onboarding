package onboarding;

import java.util.*;

public class Problem7 {
    static class Node implements Comparable<Node> {
        String name;
        int val;

        Node(String name, int val) {
            this.name = name;
            this.val = val;
        }

        public int compareTo(Node n) {
            return n.val - this.val;
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> friendSet = new HashSet<>();
        map.put(user, 0);
        for (int i = 0; i < friends.size(); i++) {
            String a = friends.get(i).get(0);
            String b = friends.get(i).get(1);
            if (a.equals(user)) {
                friendSet.add(b);
                continue;
            } else if (b.equals(user)) {
                friendSet.add(a);
                continue;
            }
            map.put(a, 0);
            map.put(b, 0);
        }
        String[] member = new String[map.size()];
        int idx = 0;
        int start = -1;
        for (String s : map.keySet()) {
            if (s.equals(user))
                start = idx;
            member[idx] = s;
            idx++;
        }
        ArrayList<Integer>[] list = new ArrayList[map.size()];
        for (int i = 0; i < map.size(); i++) {
            list[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[map.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (visit[now])
                continue;
            visit[now] = true;
            for (int next : list[now]) {
                q.offer(next);
            }
        }
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                if (friendSet.contains(member[i]))
                    continue;
                map.put(member[i], map.get(member[i]) + 10);
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            if (friendSet.contains(visitors.get(i)))
                continue;
            map.put(visitors.get(i), map.getOrDefault(visitors.get(i), 1) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (String s : map.keySet()) {
            if (friendSet.contains(s))
                continue;
            if (map.get(s) > 0) {
                pq.offer(new Node(s, map.get(s)));
            }
        }
        while (!pq.isEmpty()) {
            if (answer.size() > 4)
                break;
            answer.add(pq.poll().name);
        }
        Collections.sort(answer);
        return answer;
    }
}
