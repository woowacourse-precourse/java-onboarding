package onboarding;

import java.util.*;

public class Problem7 {
    private static List<String> getUserList(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> allUserSet = new TreeSet<>();
        allUserSet.add(user);

        for (int i = 0; i < friends.size(); i++) {
            List<String> friend = friends.get(i);
            allUserSet.add(friend.get(0));
            allUserSet.add(friend.get(1));
        }
        for (int i = 0; i < visitors.size(); i++) {
            allUserSet.add(visitors.get(i));
        }

        List<String> allUserList = new ArrayList<>(allUserSet);

        return allUserList;
    }
    private static Map<String, Integer> mappingNameToNumber(List<String> allUserList) {
        Map<String, Integer> nameToNumber = new TreeMap<>();

        for (int i = 0; i < allUserList.size(); i++) {
            nameToNumber.put(allUserList.get(i), i + 1);
        }

        return nameToNumber;
    }
    private static Map<Integer, String> mappingNumberToName(List<String> allUserList) {
        Map<Integer, String> numberToName = new TreeMap<>();

        for (int i = 0; i < allUserList.size(); i++) {
            numberToName.put(i + 1, allUserList.get(i));
        }

        return numberToName;
    }
    private static List<List<Integer>> makeUndirectedGraph(List<List<String>> friends, Map<String, Integer> nameToNumber, List<String> allUserList) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= allUserList.size(); i++) graph.add(new ArrayList<>());

        for (int i = 0; i < friends.size(); i++) {
            String friend1 = friends.get(i).get(0);
            String friend2 = friends.get(i).get(1);
            graph.get(nameToNumber.get(friend1)).add(nameToNumber.get(friend2));
            graph.get(nameToNumber.get(friend2)).add(nameToNumber.get(friend1));
        }

        return graph;
    }
    private static int[] calculateScore(String user, List<List<Integer>> adj, List<String> visitors, Map<String, Integer> nameToNumber, List<String> allUserList) {
        int[] score = new int[allUserList.size() + 1];
        int userIndex = nameToNumber.get(user);

        for (int i = 0; i < adj.get(userIndex).size(); i++) {
            int node = adj.get(userIndex).get(i);
            for (int j = 0; j < adj.get(node).size(); j++) {
                int targetNode = adj.get(node).get(j);
                if (targetNode == userIndex) continue;
                score[targetNode] += 10;
            }
        }

        for (int i = 0; i < visitors.size(); i++) {
            int index = nameToNumber.get(visitors.get(i));
            score[index]++;
        }

        for (int i = 0; i < adj.get(userIndex).size(); i++) {
            int node = adj.get(userIndex).get(i);
            score[node] = 0;
        }

        return score;
    }
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> allUserList = getUserList(user, friends, visitors);

        Map<String, Integer> nameToNumber = mappingNameToNumber(allUserList);
        Map<Integer, String> numberToName = mappingNumberToName(allUserList);

        List<List<Integer>> adj = makeUndirectedGraph(friends, nameToNumber, allUserList);

        int[] score = calculateScore(user, adj, visitors, nameToNumber, allUserList);

        return allUserList;
    }




}
