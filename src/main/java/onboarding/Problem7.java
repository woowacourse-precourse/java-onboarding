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

        List<String> userFriend = fList.get(user);

        for (String friend : userFriend) {
            calScore(friend);
        }

        for (String visitor : visitors) {
            if (!userFriend.contains(visitor)) {
                calScoreVisitors(visitor);
            }
        }

        changeKeyValue();

        return getAnswer();
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

    private static void calScore(String person) {
        List<String> temp = fList.get(person);

        for (String f : temp) {
            Integer score = sList.get(f);
            if (score != null) {
                sList.put(f, score + 10);
            }
        }
    }

    private static void calScoreVisitors(String person) {
        Integer score = sList.get(person);
        if (score == null) {
            score = 0;
        }
        score++;
        sList.put(person, score);
    }

    private static void changeKeyValue() {
        for (String key : sList.keySet()) {
            Integer score = sList.get(key);

            List<String> temp = scoreUser.get(score);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(key);
            scoreUser.put(score, temp);
        }
    }

    private static List<String> getAnswer() {
        List<String> answer = new ArrayList<>();

        List<Integer> keySet = new ArrayList<>(scoreUser.keySet());

        Collections.sort(keySet);
        Collections.reverse(keySet);

        for (int i = 0; i < keySet.size(); i++) {
            if (keySet.get(i) == 0) {
                break;
            }

            List<String> users = scoreUser.get(keySet.get(i));
            Collections.sort(users);
            answer.addAll(users);
        }

        return answer;
    }
}