package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import onboarding.validatechecker.Problem7ValidateChecker;

public class Problem7 {
    private static final int RECOMMEND_FRIEND_SIZE = 5;
    private static final int VISITOR_SCORE = 1;
    private static final int FRIENDS_FRIEND_SCORE = 10;
    private static final int INIT_SCORE = 0;
    private static final int FIRST_FRIEND = 0;
    private static final int SECOND_FRIEND = 1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Problem7ValidateChecker.areArgumentsValidate(user,friends,visitors);
        List<String> userFriendList = new ArrayList<>();
        Map<String,Integer> friendScoreMap = new HashMap<>();

        initUserFriendList(user, friends, userFriendList);
        initFriendScoreMap(friends, friendScoreMap);

        addFriendsFriendScore(friends, userFriendList, friendScoreMap,user);
        addVisitorScore(visitors, friendScoreMap);

        return genUserListSortedByScore(friendScoreMap,userFriendList);
    }

    private static List<String> genUserListSortedByScore(Map<String,Integer> friendScoreMap, List<String> userFriendList){
        List<String> userListSortedByScore = sortScoreMapByValue(friendScoreMap).stream()
            .filter(person -> !userFriendList.contains(person))
            .collect(Collectors.toList());
        if(userListSortedByScore.size() > RECOMMEND_FRIEND_SIZE)
            return new ArrayList<>(userListSortedByScore.subList(0,RECOMMEND_FRIEND_SIZE));
        return userListSortedByScore;
    }

    private static List<String> sortScoreMapByValue(Map<String, Integer> friendScoreMap) {
        return friendScoreMap.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
            .filter(user -> user.getValue() != INIT_SCORE).map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    private static void addVisitorScore(List<String> visitors, Map<String, Integer> friendScoreMap) {
        for (String visitor : visitors){
            if(friendScoreMap.containsKey(visitor))
                friendScoreMap.replace(visitor,friendScoreMap.get(visitor)+VISITOR_SCORE);
            else
                friendScoreMap.put(visitor,VISITOR_SCORE);
        }
    }

    private static void addFriendsFriendScore(List<List<String>> friends, List<String> userFriendList,
        Map<String, Integer> friendScoreMap, String user) {
        for (List<String> friendRelation : friends) {
            if(Collections.disjoint(friendRelation, userFriendList) || friendRelation.contains(user)) continue;

            String friendFirst = friendRelation.get(FIRST_FRIEND);
            String friendSecond = friendRelation.get(SECOND_FRIEND);

            if(userFriendList.contains(friendFirst))
                friendScoreMap.replace(friendSecond,friendScoreMap.get(friendSecond)+FRIENDS_FRIEND_SCORE);
            else
                friendScoreMap.replace(friendFirst,friendScoreMap.get(friendFirst)+FRIENDS_FRIEND_SCORE);
        }
    }

    private static void initFriendScoreMap(List<List<String>> friends, Map<String, Integer> friendScoreMap) {
        Set<String> userSet = friends.stream()
            .flatMap(List::stream).collect(Collectors.toSet());
        userSet.forEach(user -> friendScoreMap.put(user,INIT_SCORE));
    }

    private static void initUserFriendList(String user, List<List<String>> friends, List<String> userFriendList) {
        for (List<String> friendRelation : friends) {
            if(friendRelation.contains(user)){
                userFriendList.add(friendRelation.get(FIRST_FRIEND));
                userFriendList.add(friendRelation.get(SECOND_FRIEND));
                userFriendList.remove(user);
            }
        }
    }
}
