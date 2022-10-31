package onboarding;

import java.util.*;

public class Problem7 {
    static Map<String, List<String>> friendsMap = new HashMap<>(); //각 사람에 대한 친구 목록
    static Map<String, Integer> friendsRec = new HashMap<>(); //친구 추천 후보
    static Queue<Node> pq = new PriorityQueue<>(); //우선 순위 큐.
    static class Node implements Comparable<Node>{
        String name;
        int score;
        Node(String name, int score) {
            this.name = name;
            this.score = score;
        }
        @Override
        public int compareTo(Node o) {
            if (this.score > o.score) {
                return -1;
            } else if (this.score < o.score) {
                return 1;
            } else return this.name.compareTo(o.name);
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        makeFriendsMap(friends);
        relationScore(user);
        visitorsScore(user, visitors);
        extractRecFriends(answer);
        return answer;
    }

    private static void extractRecFriends(List<String> answer) {
        for (String s : friendsRec.keySet()) {
            pq.offer(new Node(s, friendsRec.get(s)));
        }

        while (!pq.isEmpty() && answer.size() <= 5) {
            answer.add(pq.poll().name);
        }
    }

    private static void visitorsScore(String user, List<String> visitors) {
        for (String visitor : visitors) {
            if (!friendsMap.get(user).contains(visitor)) {
                if (friendsRec.get(visitor) == null) {
                    friendsRec.put(visitor, 1);
                }
                else{
                    friendsRec.put(visitor, friendsRec.get(visitor) + 1);
                }
            }
        }
    }

    private static void relationScore(String user) {
        int cnt;
        for (String s : friendsMap.keySet()) {
            cnt = 0;
            if (s != user && friendsMap.get(user)!= null && !friendsMap.get(user).contains(s)) {
                List<String> list = friendsMap.get(s);
                for (String othersFriend : list) {
                    if(friendsMap.get(user).contains(othersFriend)) cnt++;
                }
                friendsRec.put(s, 10 * cnt);
            }
        }
    }

    private static void makeFriendsMap(List<List<String>> friends) {
        for (List<String> friend : friends) {
            String name1 = friend.get(0);
            String name2 = friend.get(1);

            friendsMap.computeIfAbsent(name1, s -> new ArrayList<>()).add(name2);
            friendsMap.computeIfAbsent(name2, s -> new ArrayList<>()).add(name1);
        }
    }
}
