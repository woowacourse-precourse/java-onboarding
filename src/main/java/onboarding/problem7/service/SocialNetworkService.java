package onboarding.problem7.service;

import onboarding.problem7.domain.FriendList;
import onboarding.problem7.domain.ScoreBoard;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SocialNetworkService {

    private static final int RECOMMEND_MIN_SCORE = 1;
    private static final int RECOMMEND_FRIEND_LIMIT_SIZE = 5;

    public static List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        FriendList friendList = new FriendList(friends);
        ScoreBoard scoreBoard = new ScoreBoard(user, friendList.allFriendList(), visitors);
        return scoreBoard.scoreBoard().entrySet().stream()
                .sorted(sortByScoreAndThenId())
                .filter(friend -> friend.getValue() >= RECOMMEND_MIN_SCORE)
                .limit(RECOMMEND_FRIEND_LIMIT_SIZE)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private static Comparator<Map.Entry<String, Integer>> sortByScoreAndThenId() {
        return (firstFriend, secondFriend) -> {
            if (firstFriend.getValue() == secondFriend.getValue()) {
                return firstFriend.getKey().compareTo(secondFriend.getKey());
            }
            return secondFriend.getValue() - firstFriend.getValue();
        };
    }
}
