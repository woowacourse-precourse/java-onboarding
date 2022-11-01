package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        HashMap<String, ArrayList<String>> relationMap = createRelation(friends);
        HashMap<String, Integer> recommendationScore = calculateRecommendationScore(user, relationMap, visitors);

        answer = sortRecommendationScore(recommendationScore);

        return answer;
    }


    private static HashMap<String, ArrayList<String>> createRelation(List<List<String>> friends) {
        HashMap<String, ArrayList<String>> relationMap = new HashMap<>();

        for (List<String> friend : friends) {
            String userA = friend.get(0);
            String userB = friend.get(1);

            relationMap = putRelation(relationMap, userA, userB);
            relationMap = putRelation(relationMap, userB, userA);
        }

        return relationMap;
    }


    private static HashMap<String, ArrayList<String>> putRelation(HashMap<String, ArrayList<String>> relationMap, String userA, String userB) {
        ArrayList<String> arrayList = new ArrayList<>();

        if (relationMap.containsKey(userA)) {
            arrayList = relationMap.get(userA);
        }
        arrayList.add(userB);
        relationMap.put(userA, arrayList);

        return relationMap;
    }


    private static HashMap<String, Integer> calculateRecommendationScore(String user, HashMap<String, ArrayList<String>> relationMap, List<String> visitors) {
        HashMap<String, Integer> recommendationScore = new HashMap<>();

        calculateFriendRecommendationScore(user, relationMap, recommendationScore);

        calculateVisitorRecommendationScore(user, relationMap, visitors, recommendationScore);

        return recommendationScore;
    }


    private static void calculateFriendRecommendationScore(String user, HashMap<String, ArrayList<String>> relationMap, HashMap<String, Integer> recommendationScore) {
        for (String isFriend : relationMap.get(user)) {
            for (String friendOfFriend : relationMap.get(isFriend)) {
                if (!(friendOfFriend == user) && !(relationMap.get(user).contains(friendOfFriend))) {
                    Integer score = 10;
                    if (recommendationScore.containsKey(friendOfFriend)) {
                        score = recommendationScore.get(friendOfFriend);
                        score += 10;
                    }
                    recommendationScore.put(friendOfFriend,score);
                }
            }
        }
    }


    private static void calculateVisitorRecommendationScore(String user, HashMap<String, ArrayList<String>> relationMap, List<String> visitors, HashMap<String, Integer> recommendationScore) {
        for (String visitor : visitors) {
            Integer score = 1;
            if (!(relationMap.get(user).contains(visitor))) {
                if (recommendationScore.containsKey(visitor)) {
                    score = recommendationScore.get(visitor);
                    score ++;
                }
                recommendationScore.put(visitor, score);
            }
        }
    }


    private static List<String> sortRecommendationScore(HashMap<String, Integer> recommendationScore) {
        List<Map.Entry<String, Integer>> recommendationList = new ArrayList<>(recommendationScore.entrySet());
        List<String> sortedRecommendationList = new ArrayList<>();

        Collections.sort(recommendationList, new ValueThenKeyComparator<>());

        for (Map.Entry<String, Integer> stringIntegerEntry : recommendationList) {
            sortedRecommendationList.add(stringIntegerEntry.getKey());
        }

        return sortedRecommendationList;
    }
}
