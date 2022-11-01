package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;
        List<String> friendsList;
        Map<String, Integer> recommendScore;

        friendsList = findUserFriends(user, friends);
        recommendScore = calculatedFriendsScore(user, friendsList, friends);
        recommendScore = calculatedVisitorsScore(friendsList, visitors, recommendScore);
        answer = calculatedRecommendation(recommendScore, friendsList);

        return answer;
    }

    private static List<String> findUserFriends(String user, List<List<String>> friends) {
        List<String> friendsList = new ArrayList<>();

        for (List<String> friend: friends) {
            if (friend.get(0).compareTo(user) == 0) {
                friendsList.add(friend.get(1));
            }
            if (friend.get(1).compareTo(user) == 0) {
                friendsList.add(friend.get(0));
            }
        }

        return friendsList;
    }

    private static Map<String, Integer> calculatedFriendsScore(String user, List<String> friendsList, List<List<String>> friends) {
        Map<String, Integer> score = new HashMap<>();

        for (List<String> friend: friends) {
            if (friend.get(0).compareTo(user) == 0 || friend.get(1).compareTo(user) == 0) {
                continue;
            }
            if (friendsList.contains(friend.get(0)) && !friendsList.contains(friend.get(1))) {
                score = calculatedScore(score, friend.get(1), 10);
            }
            if (friendsList.contains(friend.get(1)) && !friendsList.contains(friend.get(0))) {
                score = calculatedScore(score, friend.get(0), 10);
            }
        }
        return score;
    }

    private static Map<String, Integer> calculatedVisitorsScore(List<String> friendsList, List<String> visitors, Map<String, Integer> recommendScore) {
        for (String visitor: visitors) {
            calculatedScore(recommendScore, visitor, 1);
        }
        return recommendScore;
    }
    private static Map<String, Integer> calculatedScore(Map<String, Integer> score, String str, int factor) {
        if (score.containsKey(str)) {
            score.put(str, score.get(str) + factor);
            return score;
        }
        score.put(str, factor);
        return score;
    }

    private static List<String> calculatedRecommendation(Map<String, Integer> recommendScore, List<String> friendsList) {
        List<String> answer = new ArrayList<>();
        List<Entry<String, Integer>> scoreList;
        scoreList = sortRecommendation(recommendScore);

        for(Entry<String, Integer> entry : scoreList) {
            if(entry.getValue() == 0) break;
            if(friendsList.contains(entry.getKey())) continue;
            answer.add(entry.getKey());
        }

        return (answer.size() > 5) ? answer.subList(0, 4) : answer;
    }

    private static List<Entry<String, Integer>> sortRecommendation(Map<String, Integer> recommendScore) {
        List<Entry<String, Integer>> scoreList = new ArrayList<Entry<String, Integer>>(recommendScore.entrySet());
        Collections.sort(scoreList, new Comparator<Entry<String, Integer>>() {
            public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
                if (obj1.getValue().compareTo(obj2.getValue()) == 0) {
                    return obj1.getKey().compareTo(obj2.getKey());
                }
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });
        return scoreList;
    }
}