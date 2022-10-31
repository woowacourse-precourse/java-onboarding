package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friendRelations, List<String> visitors) {
        return extractTopFivePossibleFriends(user, friendRelations, visitors);
    }

    private static List<String> extractTopFivePossibleFriends(String user, List<List<String>> friendRelations, List<String> visitors) {
        Map<String, Integer> scoreMap = scorePossibleFriends(user, friendRelations, visitors);

        List<Map.Entry<String, Integer>> sortedScoreMap = sortScoreMap(scoreMap);
        return extractTopNFromSortedScoreMap(sortedScoreMap, 5);
    }

    private static Map<String, Integer> scorePossibleFriends(String user, List<List<String>> friendRelations, List<String> visitors) {
        List<String> userFriends = findFriends(user, friendRelations);

        Map<String, Integer> score = new HashMap<>();
        addScoreByFriends(score, user, userFriends, friendRelations);
        addScoreByVisitors(score, user, userFriends, visitors);

        return score;
    }

    private static List<String> findFriends(String user, List<List<String>> friendRelations) {
        List<String> output = new ArrayList<>();

        for(List<String> friendRelation : friendRelations) {
            String firstOnRelation = friendRelation.get(0);
            String secondOnRelation = friendRelation.get(1);

            if(firstOnRelation.equals(user)) {
                output.add(secondOnRelation);
            } else if(secondOnRelation.equals(user)) {
                output.add(firstOnRelation);
            }
        }

        return output;
    }

    private static void addScoreByFriends(Map<String, Integer> score, String user, List<String> userFriends, List<List<String>> friendRelations) {
        for(List<String> friendRelation : friendRelations) {
            String firstOnRelation = friendRelation.get(0);
            String secondOnRelation = friendRelation.get(1);
            String possibleFriend;

            if(userFriends.contains(firstOnRelation)) {
                possibleFriend = secondOnRelation;
            } else if(userFriends.contains(secondOnRelation)) {
                possibleFriend = firstOnRelation;
            } else {
                continue;
            }

            if(isNotUserSelfOrFriend(possibleFriend, user, userFriends)) {
                score.put(possibleFriend, score.getOrDefault(possibleFriend, 0) + 10);
            }
        }
    }

    private static void addScoreByVisitors(Map<String, Integer> score, String user, List<String> userFriends, List<String> visitors) {
        for(String visitor : visitors) {
            if(isNotUserSelfOrFriend(visitor, user, userFriends)) {
                score.put(visitor, score.getOrDefault(visitor, 0) + 1);
            }
        }
    }

    private static boolean isNotUserSelfOrFriend(String possibleFriend, String user, List<String> userFriends) {
        return !(possibleFriend.equals(user) || userFriends.contains(possibleFriend));
    }

    private static List<Map.Entry<String, Integer>> sortScoreMap(Map<String, Integer> scoreMap) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(scoreMap.entrySet());
        entryList.sort(new scoreMapComparator());

        return entryList;
    }

    private static List<String> extractTopNFromSortedScoreMap(List<Map.Entry<String, Integer>> sortedScoreMap, int num) {
        List<String> output = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            if(i == sortedScoreMap.size())
                break;
            output.add(sortedScoreMap.get(i).getKey());
        }
        return output;
    }

    private static class scoreMapComparator implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> score1, Map.Entry<String, Integer> score2) {
            if(score1.getValue().equals(score2.getValue())) {
                return score1.getKey().compareTo(score2.getKey());
            }
            return score2.getValue() - score1.getValue();
        }
    }
}
