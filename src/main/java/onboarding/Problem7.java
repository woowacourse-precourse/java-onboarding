package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        HashMap<String, Integer> userScore = makeUserScore(friends, visitors);

        List<String> userFriend = findUserFriend(user, friends);

        visitScore(visitors, userScore);

        friendScore(friends, userScore, userFriend);

        removeUserFriend(user, friends, userScore);
        removeZeroScore(userScore);

        sortAnswer(answer, userScore);

        return answer;
    }

    private static void removeZeroScore(HashMap<String, Integer> userScore) {
        Set<String> tmpSet = userScore.keySet();
        for (String name : tmpSet) {
            if (userScore.get(name) == 0) {
                userScore.remove(name);
            }
        }
    }

    private static void sortAnswer(List<String> answer, HashMap<String, Integer> userScore) {
        List<String> listKeySet = new ArrayList<>(userScore.keySet());
        listKeySet.sort((value1, value2) -> (userScore.get(value2).compareTo(userScore.get(value1))));

        List<String> tmp = new ArrayList<>(); // 이름순으로 정렬하기 위해 list

        for (int i = 0; i < listKeySet.size(); i++) {
            String name = listKeySet.get(i);
            if (i == listKeySet.size() - 1) {
                tmp.add(name);
                Collections.sort(tmp);
                answer.addAll(tmp);
            } else {
                if (userScore.get(name) != userScore.get(listKeySet.get(i + 1))) {
                    tmp.add(name);
                    Collections.sort(tmp);
                    answer.addAll(tmp);
                    tmp.clear();
                } else {
                    tmp.add(name);
                }
            }
        }
    }

    private static void removeUserFriend(String user, List<List<String>> friends, HashMap<String, Integer> userScore) {
        userScore.remove(user);
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                userScore.remove(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                userScore.remove(friends.get(i).get(0));
            }
        }
    }

    private static void friendScore(List<List<String>> friends, HashMap<String, Integer> userScore, List<String> userFriend) {
        for (int i = 0; i < friends.size(); i++) {
            if (userFriend.contains(friends.get(i).get(0))) {
                int score = userScore.get(friends.get(i).get(1));
                userScore.replace(friends.get(i).get(1), score + 10);
            } else if (userFriend.contains(friends.get(i).get(1))) {
                int score = userScore.get(friends.get(i).get(0));
                userScore.replace(friends.get(i).get(0), score + 10);
            }
        }
    }

    private static void visitScore(List<String> visitors, HashMap<String, Integer> userScore) {
        for (int i = 0; i < visitors.size(); i++) {
            int score = userScore.get(visitors.get(i));
            userScore.replace(visitors.get(i), score + 1);
        }
    }

    private static List<String> findUserFriend(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                if (!userFriend.contains(friends.get(i).get(1)))
                    userFriend.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                if (!userFriend.contains(friends.get(i).get(0)))
                    userFriend.add(friends.get(i).get(0));
            }
        }

        return userFriend;
    }

    private static HashMap<String, Integer> makeUserScore(List<List<String>> friends, List<String> visitors) {
        HashMap<String, Integer> userScore = new HashMap<>();

        for (int i = 0; i < friends.size(); i++) {
            userScore.put(friends.get(i).get(0), 0);
            userScore.put(friends.get(i).get(1), 0);
        }

        for (int i = 0; i < visitors.size(); i++) {
            userScore.put(visitors.get(i), 0);
        }

        return userScore;
    }
}