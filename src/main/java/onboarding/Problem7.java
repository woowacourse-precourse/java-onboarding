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
        //user의 친구 목록
        List<String> userFriend = fList.get(user);

        // user의 친구 중, score를 구하고자 하는 회원이 있으면 10점을 추가
        for (String friend : userFriend) {
            calScore1(friend);
        }
        // user와 친구가 아닌 visitor 들만 1점 추가
        for (String visitor : visitors) {
            if (!userFriend.contains(visitor)) {
                calScoreVisitors(visitor);
            }
        }

        changeKeyValue();

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

    private static void calScore1(String person) {
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
}