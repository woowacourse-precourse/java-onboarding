package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Arrays;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        HashMap<String, List<String>> relations = new HashMap<>();
        for (List<String> relation : friends) {
            String friendName1 = relation.get(0);
            String friendName2 = relation.get(1);
            putRelationByFriends(relations, friendName1, friendName2);
        }
        for (String friendName : visitors) {
            if (!relations.containsKey(friendName)) {
                relations.put(friendName, new ArrayList<>(Collections.emptyList()));
            }
        }
        HashMap<Integer, List<String>> recomScore = new HashMap<>();

        calScore(relations, recomScore, visitors, user);

        putNameAnswer(recomScore, answer);
        return answer;
    }

    public static void putRelationByFriends(HashMap<String, List<String>> relations, String friendName1, String friendName2) {
        if (relations.containsKey(friendName1)) {
            relations.get(friendName1).add(friendName2);
        } else {
            relations.put(friendName1, new ArrayList<>(Arrays.asList(friendName2)));
        }

        if (relations.containsKey(friendName2)) {
            relations.get(friendName2).add(friendName1);
        } else {
            relations.put(friendName2, new ArrayList<>(Arrays.asList(friendName1)));
        }
    }

    public static void calScore(HashMap<String, List<String>> relations, HashMap<Integer, List<String>> recomScore, List<String> visitors, String user) {
        for (String friendName : relations.keySet()) {
            int score = 0;
            if (!relations.get(user).contains(friendName) && !user.equals(friendName)) {
                for (String userFriend : relations.get(user)) {
                    if (relations.get(friendName).contains(userFriend)) {
                        score += 10;
                    }
                }
                for (String visitedPerson : visitors) {
                    if (visitedPerson.equals(friendName)) {
                        score ++;
                    }
                }
            }

            if (score > 0) {
                if (recomScore.containsKey(score)) {
                    recomScore.get(score).add(friendName);
                } else {
                    recomScore.put(score, new ArrayList<>(Arrays.asList(friendName)));
                }
            }
        }
    }

    public static void putNameAnswer(HashMap<Integer, List<String>> recomScore, List<String> answer) {
        List<Integer> sortedScoreList = new ArrayList<>(recomScore.keySet());
        Collections.sort(sortedScoreList, Collections.reverseOrder());
        int answerCount = 0;
        for (Integer score : sortedScoreList) {
            List<String> nameList = recomScore.get(score);
            Collections.sort(nameList);
            boolean answerIsFull = false;
            for (String name : nameList) {
                if (answerCount == 5) {
                    answerIsFull = true;
                    break;
                }
                answer.add(name);
                answerCount++;
            }

            if (answerIsFull) {
                break;
            }
        }
    }
}
