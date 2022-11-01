package onboarding.problem7;

import java.util.List;

public class FriendRecommender {

    public List<String> recommendFriends(String user, List<List<String>> friends, List<String> visitor) {

        FriendGraph friendGraph = new FriendGraph(friends);
        ScoreBoard scoreBoard = new ScoreBoard();
        Visitors visitors = new Visitors(visitor);

        addFriendOfFriendScore(scoreBoard, friendGraph, user);
        addVisitorPoint(scoreBoard, visitors);

        return getTopScoreUserName(scoreBoard, friendGraph, user);
    }

    private List<String> getTopScoreUserName(ScoreBoard scoreboard, FriendGraph graph, String user) {

        FriendCandidates friendCandidates = getFriendCandidates(scoreboard, graph, user);

        return friendCandidates.getTop5MemberName();
    }

    private FriendCandidates getFriendCandidates(ScoreBoard scoreboard, FriendGraph graph, String user) {
        FriendCandidates friendCandidates = new FriendCandidates();
        List<String> userFriends = graph.getFriends(user);
        initRemoveScoreBoard(scoreboard, user, userFriends);

        scoreboard.getKeySet().forEach(key ->
                        friendCandidates.add(new FriendCandidate(key, scoreboard.getScore(key))));

        return friendCandidates;
    }

    private void initRemoveScoreBoard(ScoreBoard scoreboard, String user, List<String> userFriends) {
        userFriends.forEach(scoreboard::remove);
        scoreboard.remove(user);
    }

    private void addFriendOfFriendScore(ScoreBoard scoreboard, FriendGraph graph, String user) {

        graph.getFriends(user)
                .stream()
                .map(graph::getFriends)
                .forEach(friends -> scoreboard.addPoint(friends, Point.FRIEND_CANDIDATE));
    }

    private void addVisitorPoint(ScoreBoard scoreboard, Visitors visitors) {
        scoreboard.addPoint(visitors.getVisitors(), Point.VISITOR);
    }

}
