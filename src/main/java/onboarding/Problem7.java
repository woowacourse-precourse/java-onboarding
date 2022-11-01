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
        List<String> recommendedFriends = createRecommendationList(findFriendOfFriend(friends, friendOfUser), visitors);
        friendOfUser.add(user);
        recommendedFriends.removeAll(friendOfUser);

        HashMap<String, Integer> score = createScoreHashMap(recommendedFriends);
        score = plusFriendOfFriend(score, findFriendOfFriend(friends, friendOfUser));
        score = plusVisitors(score, visitors);
        answer = getFinalRecommendation(score);

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

    private static List<String> createRecommendationList(List<String> friendOfFriend, List<String> visitors) {
        List<String> recommendations = new ArrayList<>();
        recommendations.addAll(friendOfFriend);
        recommendations.addAll(visitors);
        return recommendations.stream().distinct().collect(Collectors.toList());
    }

    private static HashMap<String, Integer> createScoreHashMap(List<String> recommendations) {
        HashMap<String, Integer> score = new HashMap<>();
        for (String recommendedFriend : recommendations) {
            score.put(recommendedFriend, 0);
        }
        return score;
    }

    private static HashMap<String, Integer> plusFriendOfFriend(HashMap<String, Integer> score, List<String> friendOfFriends) {
        for (String friendOfFriend : friendOfFriends) {
            if (score.containsKey(friendOfFriend))
                score.replace(friendOfFriend, score.get(friendOfFriend) + 10);
        }
        return score;
    }

    private static HashMap<String, Integer> plusVisitors(HashMap<String, Integer> score, List<String> visitors) {
        for (String visitor : visitors) {
            if (score.containsKey(visitor)) {
                score.replace(visitor, score.get(visitor) + 1);
            }
        }
        return score;
    }

    private static List<String> getFinalRecommendation(HashMap<String, Integer> score) {
        HashMap<String, Integer> sortedRecommendation = sortRecommendation(score);

        List<String> finalRecommendation = new ArrayList<>();
        for (String recommendation : sortedRecommendation.keySet())
            finalRecommendation.add(recommendation);
        return finalRecommendation;
    }

    private static HashMap<String, Integer> sortRecommendation(HashMap<String, Integer> score) {
        HashMap<String, Integer> sortedRecommendation = score.entrySet()
                .stream().sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));;

        return sortedRecommendation;
    }
}
