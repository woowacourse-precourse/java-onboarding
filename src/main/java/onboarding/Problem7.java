package onboarding;


import onboarding.problem7.*;

import java.util.List;
import java.util.Map;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        SnsId userId = new SnsId(user);
        FriendsIds friendsIds = new FriendsIds(friends);
        VisitorIds visitorsId = new VisitorIds(visitors);

        List<SnsId> acquaintanceIds = friendsIds.findAcquaintance(userId);
        List<SnsId> friendIds = friendsIds.findFriend(userId);
        List<SnsId> visitorsIds = visitorsId.getVisitors();


        RecommendFriendFinder recommendFriendFinder = new RecommendFriendFinder();

        Map<String, Integer> acquaintanceResult = recommendFriendFinder.getAcquaintanceResult(acquaintanceIds);
        Map<String, Integer> visitResult = recommendFriendFinder.getVisitResult(friendIds, visitorsIds);

        return RecommendationResult.getRecommendResult(acquaintanceResult, visitResult);
    }

}
