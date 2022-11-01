package onboarding;

import java.util.*;


public class Problem7 {

    static HashMap<String, List<String>> friendList = new HashMap<>();
    static HashMap<String, Integer> userScoreList = new HashMap<>();
    static HashMap<Integer, List<String>> scoreUserList = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> relation : friends) {
            makeSList(relation, user);
            addFriend(relation);
        }
        //user의 친구 목록
        List<String> userFriend = friendList.get(user);

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

        return getAnswer();
    }

    private static void makeSList(List<String> relation, String user) {
        if (relation.get(0) != user) {
            userScoreList.put(relation.get(0), 0);
        } else {
            userScoreList.remove(relation.get(1));
        }
        if (relation.get(1) != user) {
            userScoreList.put(relation.get(1), 0);
        } else {
            userScoreList.remove(relation.get(0));
        }
    }

    private static void addFriend(List<String> relation) {
        List<String> temp = friendList.get(relation.get(0));
        List<String> temp2 = friendList.get(relation.get(1));

        if (temp == null) {
            temp = new ArrayList<>();
        }
        if (temp2 == null) {
            temp2 = new ArrayList<>();
        }

        temp.add(relation.get(1));
        temp2.add(relation.get(0));

        friendList.put(relation.get(0), temp);
        friendList.put(relation.get(1), temp2);
    }

    private static void calScore1(String person) {
        List<String> temp = friendList.get(person);

        for (String f : temp) {
            Integer score = userScoreList.get(f);
            if (score != null) {
                userScoreList.put(f, score + 10);
            }
        }
    }

    private static void calScoreVisitors(String person) {
        Integer score = userScoreList.get(person);
        if (score == null) {
            score = 0;
        }
        score++;
        userScoreList.put(person, score);
    }

    private static void changeKeyValue() {
        for (String key : userScoreList.keySet()) {
            Integer score = userScoreList.get(key);

            List<String> temp = scoreUserList.get(score);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(key);
            scoreUserList.put(score, temp);
        }
    }

    private static List<String> getAnswer() {
        List<String> answer = new ArrayList<>();

        List<Integer> keySet = new ArrayList<>(scoreUserList.keySet());

        Collections.sort(keySet);
        Collections.reverse(keySet);

        for (int i = 0; i < keySet.size(); i++) {
            if (keySet.get(i) == 0) {
                break;
            }

            List<String> users = scoreUserList.get(keySet.get(i));
            Collections.sort(users);
            answer.addAll(users);
        }
        return answer;
    }
}