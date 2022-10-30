package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class FriendRecommender {
    private static final int FRIEND_OF_FRIEND_POINT = 10;
    private static final int VISITOR_POINT = 1;
    private static final int DEFAULT_POINT = 0;
    private static final int FRIEND_CANDIDATE_COUNT = 5;

    public List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, List<String>> graph = mapToGraph(friends);
        Map<String, Integer> scoreboard = new HashMap<>();

        addFriendOfFriendScore(scoreboard, graph, user);
        addPoint(scoreboard, VISITOR_POINT, visitors);

        return getTopScoreUserName(scoreboard, graph, user);
    }

    private List<String> getTopScoreUserName(
            Map<String, Integer> scoreboard,
            Map<String, List<String>> graph,
            String user) {

        List<FriendCandidate> friendCandidates = getFriendCandidates(scoreboard, graph, user);

        friendCandidates.sort(Collections.reverseOrder());
        List<String> friendTopList = toNameList(friendCandidates);

        return toSubList(friendTopList);
    }

    private List<FriendCandidate> getFriendCandidates(Map<String, Integer> scoreboard, Map<String, List<String>> graph, String user) {
        List<FriendCandidate> friendCandidates = new ArrayList<>();
        List<String> userFriends = graph.get(user);
        initRemoveScoreBoard(scoreboard, user, userFriends);
        scoreboard.keySet()
                .forEach(key ->
                        friendCandidates.add(new FriendCandidate(key, scoreboard.get(key))));
        return friendCandidates;
    }

    private void initRemoveScoreBoard(Map<String, Integer> scoreboard, String user, List<String> userFriends) {
        userFriends.forEach(scoreboard::remove);
        scoreboard.remove(user);
    }

    private static List<String> toSubList(List<String> friendTopList) {
        if(friendTopList.size() <= FRIEND_CANDIDATE_COUNT) {
            return friendTopList;
        }

        return friendTopList.subList(0, FRIEND_CANDIDATE_COUNT);
    }

    private List<String> toNameList(List<FriendCandidate> friendCandidates) {
        return friendCandidates.stream()
                .map(FriendCandidate::getName)
                .collect(Collectors.toList());
    }

    private void addFriendOfFriendScore(
                Map<String, Integer> scoreboard,
                Map<String, List<String>> graph,
                String user) {
        List<String> userFriends = graph.get(user);
        userFriends.forEach(friend ->
                addPoint(scoreboard,FRIEND_OF_FRIEND_POINT ,graph.get(friend)));
    }


    private Map<String, List<String>> mapToGraph(List<List<String>> userRelation){
        Map<String, List<String>> result = new HashMap<>();


        userRelation.forEach(userPair -> {
            String user1 = userPair.get(0);
            String user2 = userPair.get(1);

            initGraph(result, user1, user2);

            result.get(user1).add(user2);
            result.get(user2).add(user1);
        });
        return result;
    }

    private static void initGraph(Map<String, List<String>> result, String user1, String user2) {
        if(!result.containsKey(user1)) {
            result.put(user1, new ArrayList<>());
        }
        if(!result.containsKey(user2)) {
            result.put(user2, new ArrayList<>());
        }
    }


    private void addPoint(Map<String, Integer> scoreboard, int point, List<String> users) {
        for (String user: users) {
            if(!scoreboard.containsKey(user)) {
                scoreboard.put(user, DEFAULT_POINT);
            }

            scoreboard.put(user, scoreboard.get(user) + point);
        }
    }

}
