package onboarding;

import java.util.*;
import java.util.stream.Collectors;

/** 구현 기능 목록
 * 1. friends 리스트를 통해 사용자의 친구 리스트 생성하여 반환
 * 2. friends 리스트와 친구 리스트를 통해 친구의 친구 리스트 생성하여 반환
 * 3. visitors 리스트와 친구의 친구 리스트를 통해 추천 친구 리스트 생성하여 반환
 * 4. 추천 친구 리스트를 HashMap으로 저장
 * 5. 추천 친구 점수 계산(친구의 친구에게 10점 부여)
 * 6. 추천 친구 점수 계산(방문자에게 횟수마다 1점 부여)
 * 6. 점수가 높은 순으로 정렬하여 리스트로 반환
 * */

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> friendOfUser = findFriendOfUser(user, friends);
        List<String> recommendedFriends = getRecommendedFriends(findFriendOfFriend(friends, friendOfUser), visitors);
        friendOfUser.add(user);
        recommendedFriends.removeAll(friendOfUser);
        HashMap<String, Integer> recommendedFriendScore = getRecommendedFriendScore(recommendedFriends);
        recommendedFriendScore = plusFriendOfFriend(recommendedFriendScore, findFriendOfFriend(friends, friendOfUser));
        recommendedFriendScore = plusVisitors(recommendedFriendScore, visitors);
        answer = getFinalRecommendation(recommendedFriendScore);
        return answer;
    }

    private static List<String> findFriendOfUser(String user, List<List<String>> friends) {
        List<String> friendOfUser = new ArrayList<>();
        for (List<String> relation : friends) {
            if (relation.contains(user))
                friendOfUser.addAll(relation);
        }
        friendOfUser.removeAll(List.of(user));
        return friendOfUser;
    }

    private static List<String> findFriendOfFriend(List<List<String>> friends, List<String> friendOfUser) {
        List<String> friendOfFriend = new ArrayList<>();
        for (String friend : friendOfUser) {
            friendOfFriend.addAll(findFriendOfUser(friend, friends));
        }
        return friendOfFriend.stream().distinct().collect(Collectors.toList());
    }

    private static List<String> getRecommendedFriends(List<String> friendOfFriend, List<String> visitors) {
        List<String> recommendedFriends = new ArrayList<>();
        recommendedFriends.addAll(friendOfFriend);
        recommendedFriends.addAll(visitors);
        return recommendedFriends.stream().distinct().collect(Collectors.toList());
    }

    private static HashMap<String, Integer> getRecommendedFriendScore(List<String> recommendedFriends) {
        HashMap<String, Integer> recommendedFriendScore = new HashMap<>();
        for (String recommendedFriend : recommendedFriends) {
            recommendedFriendScore.put(recommendedFriend, 0);
        }
        return recommendedFriendScore;
    }

    private static HashMap<String, Integer> plusFriendOfFriend(HashMap<String, Integer> recommendedFriendScore, List<String> friendOfFriends) {
        for (String friendOfFriend : friendOfFriends) {
            if (recommendedFriendScore.containsKey(friendOfFriend))
                recommendedFriendScore.replace(friendOfFriend, recommendedFriendScore.get(friendOfFriend) + 10);
        }
        return recommendedFriendScore;
    }

    private static HashMap<String, Integer> plusVisitors(HashMap<String, Integer> recommendFriendScore, List<String> visitors) {
        for (String visitor : visitors) {
            if (recommendFriendScore.containsKey(visitor)) {
                recommendFriendScore.replace(visitor, recommendFriendScore.get(visitor) + 1);
            }
        }
        return recommendFriendScore;
    }

    private static List<String> getFinalRecommendation(HashMap<String, Integer> recommendedFriendScore) {
        HashMap<String, Integer> sortedRecommendation = sortRecommendation(recommendedFriendScore);

        List<String> finalRecommendation = new ArrayList<>();
        for (String recommendation : sortedRecommendation.keySet())
            finalRecommendation.add(recommendation);
        return finalRecommendation;
    }

    private static HashMap<String, Integer> sortRecommendation(HashMap<String, Integer> recommendationScore) {
        HashMap<String, Integer> sortedRecommendation = recommendationScore.entrySet()
                .stream().sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));;

        return sortedRecommendation;
    }
}
