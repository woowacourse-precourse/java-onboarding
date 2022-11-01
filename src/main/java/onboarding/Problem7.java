package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> friendsWithUser = new HashSet<>();

        friendsWithUser = checkUserFriends(user, friends, friendsWithUser);

        Map<String, Integer> score = new HashMap<>();

        score = makeFriendsList(user, friends, score, visitors, friendsWithUser);

        score = checkFriendsScore(friends, score, friendsWithUser);

        score = checkVisitorsScore(score, visitors);

        answer = getResult(answer, score);

        return answer;
    }

    public static Set<String> checkUserFriends(String user, List<List<String>> friends, Set<String> friendsWithUser) {
        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                friendsWithUser.add(friends.get(i).get(1));
            } else if (friends.get(i).get(1).equals(user)) {
                friendsWithUser.add(friends.get(i).get(0));
            } else {
                continue;
            }
        }
        return friendsWithUser;
    }

    public static Map<String, Integer> makeFriendsList(String user, List<List<String>> friends, Map<String, Integer> score, List<String> visitors, Set<String> friendsWithUser) {
        for (int i = 0; i < friends.size(); i++) {
            if (!score.containsKey(friends.get(i).get(0))) {
                if (!friends.get(i).get(0).equals(user) && !friendsWithUser.contains(friends.get(i).get(0))) {
                    score.put(friends.get(i).get(0), 0);
                }
            }
            if (!score.containsKey(friends.get(i).get(1))) {
                if (!friends.get(i).get(1).equals(user) && !friendsWithUser.contains(friends.get(i).get(1))) {
                    score.put(friends.get(i).get(1), 0);
                }
            }
        }
        for (int i = 0; i < visitors.size(); i++) {
            if (!score.containsKey(visitors.get(i))) {
                score.put(visitors.get(0), 0);
            } else {
                continue;
            }
        }
        return score;
    }

    public static Map<String, Integer> checkFriendsScore(List<List<String>> friends, Map<String, Integer> score, Set<String> friendsWithUser) {
        for (int i = 0; i < score.size(); i++) {
            if (friendsWithUser.contains(friends.get(i).get(0))) {
                if (score.containsKey(friends.get(i).get(1))) {
                    score.put(friends.get(i).get(1), score.get(friends.get(i).get(1)) + 10);
                }
            }
            if (friendsWithUser.contains(friends.get(i).get(1))) {
                if (score.containsKey(friends.get(i).get(0))) {
                    score.put(friends.get(i).get(0), score.get(friends.get(i).get(0)) + 10);
                }
            }
        }
        return score;
    }

    public static Map<String, Integer> checkVisitorsScore(Map<String, Integer> score, List<String> visitors) {
        for (int i = 0; i < visitors.size(); i++) {
            if (score.containsKey(visitors.get(i))) {
                score.put(visitors.get(i), score.get(visitors.get(i)) + 1);
            }
        }
        return score;
    }

    public static List<String> getResult(List<String> answer, Map<String, Integer> score) {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(score.entrySet());
        Collections.sort(entries, (score1, score2) -> score2.getValue().compareTo(score1.getValue()));
        for (int i = 0; i < entries.size(); i++) {
            if (i == 5 || entries.get(i).getValue() == 0) {
                break;
            }
            answer.add(entries.get(i).getKey());
        }
        return answer;
    }
}
