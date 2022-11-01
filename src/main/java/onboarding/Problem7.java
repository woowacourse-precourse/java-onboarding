package onboarding;

import java.util.*;


public class Problem7 {

    static HashMap<String, List<String>> fList = new HashMap<>();
    static HashMap<String, Integer> sList = new HashMap<>();
    static HashMap<Integer, List<String>> scoreUser = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        for (List<String> relation : friends) {
            makeSList(relation, user);
        }
        return answer;
    }

    private static void makeSList(List<String> relation, String user) {
        if (relation.get(0) != user) {
            sList.put(relation.get(0), 0);
        } else {
            sList.remove(relation.get(1));
        }
        if (relation.get(1) != user) {
            sList.put(relation.get(1), 0);
        } else {
            sList.remove(relation.get(0));
        }
    }
}