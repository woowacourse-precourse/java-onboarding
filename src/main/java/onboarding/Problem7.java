package onboarding;


import onboarding.problem7.FriendsException;
import onboarding.problem7.RecommendFriendFinder;
import onboarding.problem7.RecommendationResult;
import onboarding.problem7.SNSId;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int MAX = 10_000;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SNSId userId = new SNSId(user);

        checkFriends(friends);
        checkMaxVisit(visitors);

        RecommendFriendFinder recommendFriendFinder = new RecommendFriendFinder();
        List<List<SNSId>> friendsIds = convertFriendsId(friends);
        Map<String, Integer> acquaintanceResult = recommendFriendFinder.getAcquaintanceResult(userId, friendsIds);
        Map<String, Integer> visitResult = recommendFriendFinder.getVisitResult(userId, friendsIds, convertVisitorIds(visitors));

        return RecommendationResult.getRecommendResult(acquaintanceResult,visitResult);
    }

    private static List<SNSId> convertVisitorIds(List<String> visitors) {
        return visitors.stream().map(SNSId::new).collect(Collectors.toList());
    }

    private static void checkMaxVisit(List<String> visitors) {
        if (visitors.size() > MAX) {
            throw new FriendsException("처리할 수 있는 친구 정보보다 더 많습니다.");
        }
    }

    private static void checkFriends(List<List<String>> friends) {
        checkMin(friends);
        checkMAX(friends);
    }

    private static List<List<SNSId>> convertFriendsId(List<List<String>> friends) {
        return friends.stream()
                .map(friend -> friend.stream().map(SNSId::new)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    private static void checkMAX(List<List<String>> friends) {
        if (friends.size() > MAX) {
            throw new FriendsException("처리할 수 있는 친구 정보보다 더 많습니다.");
        }
    }

    private static void checkMin(List<List<String>> friends) {
        if (friends.isEmpty()) {
            throw new FriendsException("친구 관계 정보가 없습니다.");
        }
    }
}
