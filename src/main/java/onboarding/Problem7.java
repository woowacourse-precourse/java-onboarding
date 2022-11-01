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
            addFriend(relation);
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

    private static void addFriend(List<String> relation) {
        List<String> temp = fList.get(relation.get(0));
        List<String> temp2 = fList.get(relation.get(1));

        if (temp == null) {
            temp = new ArrayList<>();
        }
        if (temp2 == null) {
            temp2 = new ArrayList<>();
        }

        temp.add(relation.get(1));
        temp2.add(relation.get(0));

        fList.put(relation.get(0), temp);
        fList.put(relation.get(1), temp2);
    }
}