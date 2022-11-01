package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Integer> scoreMap = new HashMap<>();

        List<String> userFriends = getUserFriends(friends, user);

        userFriendsKnowScore(friends, userFriends, scoreMap);
        timelineCalScore(visitors, userFriends, scoreMap);

        answer = sortNameByScore(scoreMap, user);

        if (answer.size() > 5) {
            answer = answer.subList(0,5);
        }

        return answer;
    }

    private static void userFriendsKnowScore(
        List<List<String>> friends, List<String> userFriends, Map<String, Integer> score) {

        for (List<String> friend: friends) {
            String fromUser = friend.get(0);
            String toUser = friend.get(1);
            int addedScore = 0;

            if (!userFriends.contains(fromUser) && !userFriends.contains(toUser)) {
                continue;
            }

            if (userFriends.contains(fromUser) && score.containsKey(toUser)) {
                addedScore = score.get(toUser) + 10;
                score.replace(toUser, addedScore);
            } else if (userFriends.contains(toUser) && score.containsKey(fromUser)) {
                addedScore = score.get(fromUser) + 10;
                score.replace(fromUser, addedScore);
            } else if (userFriends.contains(fromUser) && !score.containsKey(toUser)) {
                score.put(toUser, 10);
            } else if (userFriends.contains(toUser) && !score.containsKey(fromUser)) {
                score.put(fromUser, 10);
            }
        }

    }

    private static List<String> sortNameByScore(Map<String, Integer> score, String user) {
        List<String> result = new ArrayList<>(score.keySet());

        result.remove(user);
        Collections.sort(result);
        result.sort(new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return score.get(o2).compareTo(score.get(o1));
                }
        });

        return result;
    }

    private static void timelineCalScore(List<String> visitors, List<String> userFriends, Map<String, Integer> score) {
        for (String visitor: visitors) {
            if (userFriends.contains(visitor)) {
                continue;
            }

            if (score.containsKey(visitor)) {
                int addedScore = score.get(visitor) + 1;
                score.put(visitor, addedScore);

                continue;
            }

            score.put(visitor, 1);
        }
    }

    private static List<String> getUserFriends(List<List<String>> friends, String user) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend: friends) {
            String fromUser = friend.get(0);
            String toUser = friend.get(1);

            if (userFriends.contains(fromUser) || userFriends.contains(toUser)) {
                continue;
            }

            if (fromUser.equals(user)) {
                userFriends.add(toUser);
            } else if (toUser.equals(user)) {
                userFriends.add(fromUser);
            }
        }

        return userFriends;
    }
}
