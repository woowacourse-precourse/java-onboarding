package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    private static final int FROM = 0;
    private static final int TO = 1;
    private static final int VISIT_SCORE = 1;
    private static final int FRIEND_SCORE = 10;

    private static Map<String, Set<String>> getRelation(List<List<String>> friends) {
        Map<String, Set<String>> friendsByName = new HashMap<>();

        for (List<String> friend : friends) {
            String from = friend.get(FROM);
            String to = friend.get(TO);
            if (!friendsByName.containsKey(from)) {
                friendsByName.put(from, new HashSet<>());
            }
            if (!friendsByName.containsKey(to)) {
                friendsByName.put(to, new HashSet<>());
            }
            friendsByName.get(from).add(to);
            friendsByName.get(to).add(from);
        }
        return friendsByName;
    }
    private static Map<String, Integer> getVisitorScore(List<String> visitors) {
        Map<String, Integer> visitorScore = new HashMap<>();

        for (String visitor : visitors) {
            if (!visitorScore.containsKey(visitor)) {
                visitorScore.put(visitor, 0);
            }
            int visitCnt = visitorScore.get(visitor);
            visitorScore.replace(visitor, visitCnt + VISIT_SCORE);
        }
        return visitorScore;
    }

    private static void storeCandidatesFromFriendsByName(Set<String> candidates,
                                                         Map<String, Set<String>> friendsByName) {
        candidates.addAll(friendsByName.keySet());
    }

    private static void storeCandidatesFromVisitorScore(Set<String> candidates,
                                                        Map<String, Integer> visitorScore) {
        candidates.addAll(visitorScore.keySet());
    }

    private static void checkCandidates(Set<String> candidates,
                                        List<String> userFriends,
                                        String user) {
        if (userFriends != null) {
            for (String userFriend : userFriends) {
                candidates.remove(userFriend);
            }
        }
        candidates.remove(user);
    }

    private static Set<String> getCandidates(Map<String, Set<String>> friendsByName,
                                             Map<String, Integer> visitorScore,
                                             List<String> userFriends,
                                             String user) {
        Set<String> candidates = new HashSet<>();

        storeCandidatesFromFriendsByName(candidates, friendsByName);
        storeCandidatesFromVisitorScore(candidates, visitorScore);
        checkCandidates(candidates, userFriends, user);
        return candidates;
    }

    private static Map<String, Integer> createScoreByName(Set<String> candidates) {
        Map<String, Integer> scoreByName = new HashMap<>();

        for (String candidate : candidates) {
            scoreByName.put(candidate, 0);
        }
        return scoreByName;
    }

    private static void calcFriendScore(Map<String, Integer> scoreByName,
                                        Map<String, Set<String>> friendByName,
                                        List<String> userFriends) {
        if (userFriends == null) {
            return;
        }
        Set<String> names = scoreByName.keySet();

        for (String name : names) {
            Set<String> friends = friendByName.get(name);
            if (friends == null) {
                continue;
            }
            for (String userFriend : userFriends) {
                if (friends.contains(userFriend)) {
                    Integer score = scoreByName.get(name);
                    scoreByName.replace(name, score + FRIEND_SCORE);
                }
            }
        }
    }

    private static void calcVisitorScore(Map<String, Integer> scoreByName,
                                         Map<String, Integer> visitorScore) {
        Set<String> names = scoreByName.keySet();

        for (String name : names) {
            if (visitorScore.containsKey(name)) {
                int score = scoreByName.get(name);
                scoreByName.replace(name, score + visitorScore.get(name));
            }
        }
    }

    private static void sortRecommendList(List<Map.Entry<String, Integer>> recommendList) {
        recommendList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().equals(o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
    }

    public static List<String> checkRecommendList(List<Map.Entry<String, Integer>> recommendList) {
        List<String> checkedList = new ArrayList<>();

        for (Map.Entry<String, Integer> score : recommendList) {
            if (score.getValue() != 0) {
                checkedList.add(score.getKey());
            }
        }
        if (checkedList.size() > 5) {
            checkedList = checkedList.subList(0, 5);
        }
        return checkedList;
    }

    private static List<String> getUserFriends(Map<String, Set<String>> friendsByName, String user) {
        if (friendsByName.get(user) != null) {
            return new ArrayList<>(friendsByName.get(user));
        }
        return null;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        Map<String, Set<String>> friendsByName;
        List<String> userFriends;
        Map<String, Integer> visitorScore;
        Set<String> candidates;
        Map<String, Integer> scoreByName;
        List<Map.Entry<String, Integer>> recommendList;

        friendsByName = getRelation(friends);
        userFriends = getUserFriends(friendsByName, user);
        visitorScore = getVisitorScore(visitors);
        candidates = getCandidates(friendsByName, visitorScore, userFriends, user);
        scoreByName = createScoreByName(candidates);
        calcFriendScore(scoreByName, friendsByName, userFriends);
        calcVisitorScore(scoreByName, visitorScore);
        recommendList = new ArrayList<>(scoreByName.entrySet());
        sortRecommendList(recommendList);
        answer = checkRecommendList(recommendList);
        return answer;
    }
}
