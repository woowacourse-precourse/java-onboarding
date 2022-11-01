package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        Map<String, Set<String>> friendshipGraph = new HashMap<>();
        initFriendshipGraph(friends, friendshipGraph, user);

        Map<String, Integer> visitorInfo = new HashMap<>();
        initVisitorInfo(visitors, visitorInfo, user, friendshipGraph);

        Map<String, Integer> friendOfFriend = new HashMap<>();
        findFriendOfFriend(user, friendshipGraph, friendOfFriend);

        Map<Integer, List<String>> recommendScore = new HashMap<>();
        calculateRecommendScore(visitorInfo, friendOfFriend, recommendScore);

        List<Integer> scores = getSortedScoreList(recommendScore);
        getAnswer(answer, recommendScore, scores);
        return answer;
    }

    /**
     * Function for friendshipGraph that represent all friendship as a graph
     * */
    private static void initFriendshipGraph(List<List<String>> friends, Map<String, Set<String>> friendshipGraph,
                                            String user) {

        friendshipGraph.put(user, new HashSet<String>());

        for (List<String> each : friends) {
            String person1 = each.get(0);
            String person2 = each.get(1);

            if (!friendshipGraph.containsKey(person1)) {
                friendshipGraph.put(person1, new HashSet<String>());
            }

            if (!friendshipGraph.containsKey(person2)) {
                friendshipGraph.put(person2, new HashSet<String>());
            }

            friendshipGraph.get(person1).add(person2);
            friendshipGraph.get(person2).add(person1);
        }
    }

    /**
     * Function for visitorInfo that mapping visitor name and visit nums
     * */
    private static void initVisitorInfo(List<String> visitors, Map<String, Integer> visitorInfo,
                                        String user, Map<String, Set<String>> friendshipGraph) {
        for (String visitor : visitors) {
            if (friendshipGraph.get(user).contains(visitor)) {
                continue;
            }
            if (visitorInfo.containsKey(visitor)) {
                visitorInfo.put(visitor, visitorInfo.get(visitor)+1);
            } else {
                visitorInfo.put(visitor, 1);
            }
        }
    }

    /**
     * Function for finding friends of friends who are not user's friends
     * */
    private static void findFriendOfFriend(String user, Map<String, Set<String>> friendshipGraph,
                                           Map<String, Integer> friendOfFriend) {
        Map<String, Integer> checkSet = new HashMap<>();
        checkSet.put(user,0);
        Queue<String> queue = new LinkedList<>();
        queue.add(user);
        String person;
        int value;
        while (!queue.isEmpty()) {
            person = queue.remove();
            value = checkSet.get(person);
            if (value == 2) {
                break;
            }
            for (String next : friendshipGraph.get(person)) {
                if (value == 0) {
                    if (!checkSet.containsKey(next)) {
                        checkSet.put(next, 1);
                        queue.add(next);
                    }
                } else if (value == 1) {
                    if (!checkSet.containsKey(next)) {
                        checkSet.put(next, 2);
                        friendOfFriend.put(next, 1);
                        queue.add(next);
                    } else {
                        if (!next.equals(user) && checkSet.get(next) != 1) {
                            friendOfFriend.put(next, friendOfFriend.get(next)+1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Function for calculating friend recommend score
     * */
    private static void calculateRecommendScore(Map<String, Integer> visitorInfo, Map<String, Integer> friendOfFriend,
                                               Map<Integer, List<String>> recommendScore) {
        for (String each : friendOfFriend.keySet()) {
            int withScore = friendOfFriend.get(each) * 10;
            int visitScore = 0;
            if (visitorInfo.containsKey(each)) {
                visitScore = visitorInfo.get(each);
            }
            int score = withScore+visitScore;

            if (!recommendScore.containsKey(score)) {
                recommendScore.put(score, new ArrayList<String>());
            }
            recommendScore.get(score).add(each);
        }

        for (String each : visitorInfo.keySet()) {
            int visitScore = visitorInfo.get(each);
            if (!friendOfFriend.containsKey(each)) {
                int score = visitScore;
                if (!recommendScore.containsKey(score)) {
                    recommendScore.put(score, new ArrayList<String>());
                }
                recommendScore.get(score).add(each);
            }
        }
    }

    /**
     * Function for getting Sorted Score List
     * */
    private static List<Integer> getSortedScoreList(Map<Integer, List<String>> recommendScore) {
        List<Integer> scores = new ArrayList<>();
        for (int scoreNum : recommendScore.keySet()) {
            scores.add(scoreNum);
        }
        Collections.sort(scores, Collections.reverseOrder());
        return scores;
    }

    /**
     * Function for friends sorted by recommendation score
     * */
    private static void getAnswer(List<String> answer, Map<Integer, List<String>> recommendScore, List<Integer> scores) {
        for (int score : scores) {
            List<String> recommendFriends = recommendScore.get(score);
            Collections.sort(recommendFriends);
            answer.addAll(recommendFriends);
            if (answer.size() > 5) {
                break;
            }
        }
        extractMaxFiveList(answer);
    }

    /**
     * Function for checking final friends List Length
     * */
    private static void extractMaxFiveList(List<String> answer) {
        while (answer.size() > 5) {
            answer.remove(answer.size()-1);
        }
    }
}
