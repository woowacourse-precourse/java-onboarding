package onboarding;

import org.mockito.internal.matchers.Null;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        friends = new ArrayList<>(friends);
        visitors = new ArrayList<>(visitors);
        HashMap<String, Integer> scores = new HashMap<>();
        List<String> userFriends = new ArrayList<>();

        getUserFriend(user, friends, userFriends);
        getScores(friends, visitors, scores, userFriends);
        List<Map.Entry<String, Integer>> scoreList = sortScores(scores);
        getRecommendFriends(answer, scoreList);

        return answer;
    }

    private static void getUserFriend(String user, List<List<String>> friends, List<String> userFriends) {
        for (Iterator<List<String>> iterator = friends.iterator(); iterator.hasNext();) {
            List<String> friend = iterator.next();
            if (user.equals(friend.get(0))) {
                userFriends.add(friend.get(1));
                iterator.remove();
            } else if (user.equals(friend.get(1))) {
                userFriends.add(friend.get(0));
                iterator.remove();
            }
        }
    }

    private static void scoreUserFriend(List<List<String>> friends, HashMap<String, Integer> scores, String userFriend) {
        for (List<String> friend : friends) {
            if (userFriend.equals(friend.get(0))) {
                scores.merge(friend.get(1), 10, Integer::sum);
            } else if (userFriend.equals(friend.get(1))) {
                scores.merge(friend.get(0), 10, Integer::sum);
            }
        }
    }

    private static void scoreVisited(List<String> visitors, HashMap<String, Integer> scores) {
        for (String visitor : visitors) {
            scores.merge(visitor, 1, Integer::sum);
        }
    }

    private static void getScores(List<List<String>> friends, List<String> visitors, HashMap<String, Integer> scores, List<String> userFriends) {
        for(String userFriend : userFriends){
            scoreUserFriend(friends, scores, userFriend);
        }
        for(String userFriend : userFriends){
            visitors.removeIf(userFriend::equals);
        }
        scoreVisited(visitors, scores);
    }

    private static List<Map.Entry<String, Integer>> sortScores(HashMap<String, Integer> scores) {
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(scores.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                }
                else if (o1.getValue() < o2.getValue()) {
                    return 1;
                }

                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return entryList;
    }

    private static void getRecommendFriends(List<String> answer, List<Map.Entry<String, Integer>> scoreList) {
        if (scoreList.size() < 5) {
            for (Map.Entry<String, Integer> score : scoreList) {
                String nickname = score.getKey();
                answer.add(nickname);
            }
        } else {
            for (int i = 0; i < 5; i++) {
                Map.Entry<String, Integer> score = scoreList.get(i);
                String nickname = score.getKey();
                answer.add(nickname);

            }
        }
    }
}
