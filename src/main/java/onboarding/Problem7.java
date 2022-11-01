package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem7 {

    private static int sequence;
    private static Map<String, Integer> indexMap = new HashMap<>();
    private static List<Integer>[] friendship = new ArrayList[10000];
    private static int[] scoreList = new int[10000];
    private static String[] nameList = new String[10000];
    private static PriorityQueue<Pair> pq = new PriorityQueue<>();


    private static boolean checkAlpha(String s) {
        char index;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            index = s.charAt(i);
            if (!('a' <= index && index <= 'z')) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkUser(String user) {
        int length = user.length();

        if (length == 0 || length > 30) {
            return true;
        } else {
            return checkAlpha(user);
        }
    }

    private static boolean checkUserList(List<String> userList) {
        String user;
        int size = userList.size();

        for (int i = 0; i < size; i++) {
            user = userList.get(i);
            if (checkUser(user)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkFriends(List<List<String>> friends) {
        List<String> indexList;
        String index;
        int size = friends.size();

        if (size == 0 || size > 10000) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            indexList = friends.get(i);
            if (checkUserList(indexList)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkParam(String user, List<List<String>> friends, List<String> visitors) {
        if (user == null || friends == null || visitors == null) {
            return true;
        } else if (checkUser(user)) {
            return true;
        } else if (checkFriends(friends)) {
            return true;
        } else {
            return checkUserList(visitors);
        }
    }

    private static void initSolution(String user, List<List<String>> friends) {
        String f1, f2;
        List<String> friendList;
        int f1Index, f2Index;
        int size = friends.size();

        indexMap.clear();
        pq.clear();
        for (int i = 0; i < 10000; i++) {
            scoreList[i] = 0;
            nameList[i] = null;
            friendship[i] = new ArrayList<>();
        }
        sequence = 0;
        nameList[sequence] = user;
        indexMap.put(user, sequence++);
        for (int i = 0; i < size; i++) {
            friendList = friends.get(i);
            f1 = friendList.get(0);
            f2 = friendList.get(1);
            if (!indexMap.containsKey(f1)) {
                nameList[sequence] = f1;
                indexMap.put(f1, sequence++);
            }
            if (!indexMap.containsKey(f2)) {
                nameList[sequence] = f2;
                indexMap.put(f2, sequence++);
            }
            f1Index = indexMap.get(f1);
            f2Index = indexMap.get(f2);
            if (!friendship[f1Index].contains(f2Index)) {
                friendship[f1Index].add(f2Index);
            }
            if (!friendship[f2Index].contains(f1Index)) {
                friendship[f2Index].add(f1Index);
            }
        }
    }

    private static void initScoreList() {
        scoreList[0] = -1;
        for (int i = 0; i < friendship[0].size(); i++) {
            scoreList[friendship[0].get(i)] = -1;
        }
    }

    private static void calcScore(int index) {
        for (int i = 0; i < friendship[index].size(); i++) {
            if (scoreList[friendship[index].get(i)] == -1) {
                scoreList[index] += 10;
            }
        }
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        String visitor;
        List<String> answer = new ArrayList<>(Collections.emptyList());

        if (checkParam(user, friends, visitors))
            return Collections.emptyList();

        initSolution(user, friends);
        initScoreList();
        for (int i = 1; i < sequence; i++) {
            if (scoreList[i] == -1) {
                continue;
            }
            calcScore(i);
        }
        for (int i = 0; i < visitors.size(); i++) {
            visitor = visitors.get(i);
            if (!indexMap.containsKey(visitor)) {
                scoreList[sequence] = 1;
                nameList[sequence] = visitor;
                indexMap.put(visitor, sequence++);
            } else if (scoreList[indexMap.get(visitor)] != -1) {
                scoreList[indexMap.get(visitor)]++;
            }
        }
        for (int i = 1; i < sequence; i++) {
            if (scoreList[i] != -1) {
                pq.add(new Pair(scoreList[i], nameList[i]));
            }
        }
        while (!pq.isEmpty() && answer.size() < 5) {
            if (pq.peek().score != 0) {
                answer.add(pq.peek().name);
            }
            pq.poll();
        }
        return answer;
    }

    private static class Pair implements Comparable<Pair> {
        int score;
        String name;

        public Pair(int score, String name) {
            this.score = score;
            this.name = name;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.score > o.score) {
                return -1;
            } else if (this.score == o.score) {
                return this.name.compareTo(o.name);
            } else {
                return 1;
            }
        }
    }
}
