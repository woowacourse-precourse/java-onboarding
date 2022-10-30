package onboarding.problem7.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Recommender {

    private static final int ACQUAINTANCE_SCORE = 10;

    private static final int VISIT_SCORE = 1;

    /**
     * 추천 대상과 점수를 가진 Map
     * Key : 추천 대상 User
     * Value : 추천 점수
     */
    private final HashMap<User, Integer> recommendMap = new HashMap<>();

    public List<Recommend> recommend(User user) {

        // 함께 아는 친구를 통한 점수 계산
        calculateScoreByAcquaintance(user);

        // 타임라인 방문횟수를 통한 점수 계산
        calculateScoreByVisitor(user);

        // 계산된 점수를 통한 추천 결과 반환
        return getRecommendResult(user);
    }

    private void calculateScoreByAcquaintance(User user) {
        Set<User> friends = user.getFriends();

        for (User friend : friends) {
            calculateScoreByStrategy(user, friend.getFriends(), ACQUAINTANCE_SCORE);
        }
    }

    private void calculateScoreByStrategy(User user, Iterable<User> candidates, int scoreStrategy) {
        for (User candidate : candidates) {

            // 이미 친구이거나, 유저 본인인 경우 생략
            if (user.equals(candidate) || user.isFriends(candidate)) {
                continue;
            }

            if (isUserNotRegistered(user)) {
                recommendMap.put(candidate, 0);
            }

            int updatedScore = recommendMap.get(candidate) + scoreStrategy;
            recommendMap.put(candidate,updatedScore);
        }
    }

    private boolean isUserNotRegistered(User user) {
        return !recommendMap.containsKey(user);
    }

    private void calculateScoreByVisitor(User user) {
        calculateScoreByStrategy(user, user.getVisitors(), VISIT_SCORE);
    }

    private List<Recommend> getRecommendResult(User user) {
        return recommendMap
                .keySet()
                .stream()
                // 추천 점수가 0보다 낮으면 추천하지 않음
                .filter(ru -> recommendMap.get(ru) > 0)
                .map(ru -> new Recommend(user, ru, recommendMap.get(ru)))
                .collect(Collectors.toList());
    }
}
