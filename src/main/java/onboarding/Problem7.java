package onboarding;

import java.util.*;

public class Problem7 {

    private static List<String> alreadyFriend;
    private static HashMap<String, Integer> scoreMap;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        init(user);
        putFriendsToMap(user, friends);
        give10ScoreForFriendOfFriend(friends);
        give1ScoreForVisitor(visitors);
        removeUnnecessary(user);

        List<String> answer = new ArrayList<>(scoreMap.keySet());
        sortByMapValueDescending(answer);
        return limitAnswerNumUnder5(answer);
    }

    private static void init(String user) {
        alreadyFriend = new ArrayList<>();
        scoreMap = new HashMap<>();
        scoreMap.put(user, 0);
    }

    private static void putFriendsToMap(String user, List<List<String>> friends) {
        for (List<String> list : friends) {
            if (list.get(0).equals(user)) {
                alreadyFriend.add(list.get(1));
                scoreMap.put(list.get(1), 0);
            } else if (list.get(1).equals(user)) {
                alreadyFriend.add(list.get(0));
                scoreMap.put(list.get(0), 0);
            } else {
                if(!scoreMap.containsKey(list.get(0))) scoreMap.put(list.get(0), 0);
                if(!scoreMap.containsKey(list.get(1))) scoreMap.put(list.get(1), 0);
            }
        }
    }

    private static void give10ScoreForFriendOfFriend(List<List<String>> friends) {
        for (List<String> list : friends) {
            if (alreadyFriend.contains(list.get(0))) {
                int score = scoreMap.get(list.get(1)) + 10;
                scoreMap.put(list.get(1), score);
            } else if (alreadyFriend.contains(list.get(1))) {
                int score = scoreMap.get(list.get(0)) + 10;
                scoreMap.put(list.get(0), score);
            }
        }
    }

    private static void give1ScoreForVisitor(List<String> visitors) {
        for (String visitor : visitors) {
            if (scoreMap.containsKey(visitor)) {
                int score = (scoreMap.get(visitor)) + 1;
                scoreMap.put(visitor, score);
            } else {
                scoreMap.put(visitor, 1);
            }
        }
    }

    private static void removeUnnecessary(String user) {
        // map에 들어가있던 user와 user의 친구는 결과값에 불필요하므로, 제거한다.
        scoreMap.remove(user);
        alreadyFriend.forEach(scoreMap::remove);
    }

    private static void sortByMapValueDescending(List<String> answer) {
        answer.sort((value1, value2) -> (scoreMap.get(value2).compareTo(scoreMap.get(value1))));
    }

    private static List<String> limitAnswerNumUnder5(List<String> answer) {
        if (answer.size() < 5) {
            return answer;
        } else {
            List<String> realAnswer = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                realAnswer.add(answer.get(i));
            }
            return realAnswer;
        }
    }
}
