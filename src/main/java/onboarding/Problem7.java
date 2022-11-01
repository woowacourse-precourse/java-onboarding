package onboarding;

import com.sun.jdi.ArrayReference;

import java.util.*;
import java.util.Map.Entry;

public class Problem7 {
    static class Graph {
        private ArrayList<ArrayList<Integer>> graph;
        public Graph(int size) {
            this.graph = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < size; i++) {
                graph.add(new ArrayList<Integer>());
            }
        }
        public ArrayList<Integer> get(int i) {
            return this.graph.get(i);
        }
        public void put(int x, int y) {
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
    }
    static Problem7_backup.Graph graph;
    static int id = 0;
    static HashMap<String, Integer> scoreTable = new HashMap<>();
    static HashMap<String, Integer> idTable = new HashMap<>();
    static HashMap<Integer, String> nameTable = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        ArrayList<String> answer = new ArrayList<>();
        graph = new Problem7_backup.Graph(friends.size());

        initTables(friends);
        initGraph(friends);

        // 주인공 입장에서 아는 친구들 일단 구하기
        ArrayList<Integer> friendOfUser = graph.get(idTable.get(user));

        // 나머지 입장에서 주인공이랑 겹치는 친구들 구해서 점수에 더해주기
        addIntersectFriendScore(user, friendOfUser);

        // 방문 횟수만큼 점수에 더해주기
        addVisitorScore(visitors);

        // 자기 자신이나 이미 친구인 애들, 그리고 점수가 0점인 애들은 지워주기
        eraseNotQualified(user, friendOfUser);

        // entryset 정렬하되, 겹치면 알파벳 순
        List<Entry<String, Integer>> scoreList = new LinkedList<>(scoreTable.entrySet());
        scoreList.sort(new Comparator<Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                if (o1.getValue() - o2.getValue() == 0) {
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    return s1.compareTo(s2);
                }

                return o2.getValue()-o1.getValue();
            }
        });

        for (Entry<String, Integer> entry: scoreList) {
            answer.add(entry.getKey());
        }

        return answer;
    }

    private static void initGraph(List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> friendsList = friends.get(i);
            String friendA = friendsList.get(0);
            String friendB = friendsList.get(1);
            graph.put(idTable.get(friendA), idTable.get(friendB));
        }
    }

    private static void initTables(List<List<String>> friends) {
        for (int i = 0; i < friends.size(); i++) {
            List<String> friendsList = friends.get(i);
            String friendA = friendsList.get(0);
            if (!idTable.containsKey(friendA)) {
                idTable.put(friendA, id);
                nameTable.put(id++, friendA);
                scoreTable.put(friendA, 0);
            }
            String friendB = friendsList.get(1);
            if (!idTable.containsKey(friendB)) {
                idTable.put(friendB, id);
                nameTable.put(id++, friendB);
                scoreTable.put(friendB, 0);
            }
        }
    }

    private static void addIntersectFriendScore(String user, ArrayList<Integer> friendOfUser) {
        for (Entry<Integer, String> entrySet: nameTable.entrySet()) {
            if (entrySet.getValue().equals(user)) continue;
            ArrayList<Integer> friendOfOthers = graph.get(entrySet.getKey());
            friendOfOthers.retainAll(friendOfUser);

            int score = scoreTable.get(entrySet.getValue()) + friendOfOthers.size()*10;
            scoreTable.put(entrySet.getValue(), score);
        }
    }

    private static void addVisitorScore(List<String> visitors) {
        for (String name: visitors) {
            if (!idTable.containsKey(name)) {
                idTable.put(name, id);
                nameTable.put(id++, name);
                scoreTable.put(name, 0);
            }

            int score = scoreTable.get(name) + 1;
            scoreTable.put(name, score);
        }
    }

    private static void eraseNotQualified(String user, ArrayList<Integer> friendOfUser) {
        for (Entry<Integer, String> entrySet: nameTable.entrySet()) {
            if (friendOfUser.contains(entrySet.getKey()) ||
                    entrySet.getValue().equals(user) ||
                    scoreTable.get(entrySet.getValue()) == 0
            ) {
                scoreTable.remove(entrySet.getValue());
            }
        }
    }
}
