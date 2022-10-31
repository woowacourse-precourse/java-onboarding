package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    private static final int RECOMMEND_FRIEND_SIZE = 5;
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriendList = new ArrayList<>();
        Map<String,Integer> friendScoreMap = new HashMap<>();

        initUserFriendList(user, friends, userFriendList);
        initFriendScoreMap(friends, friendScoreMap);

        addScoreFriendsFriend(friends, userFriendList, friendScoreMap,user);
        addScoreVisitor(visitors, friendScoreMap);

        return genUserListSortedByScore(friendScoreMap,userFriendList);
    }

    private static List<String> genUserListSortedByScore(Map<String,Integer> friendScoreMap, List<String> userFriendList){
        List<String> userListSortedByScore = sortScoreMapByValue(friendScoreMap).stream()
            .filter(person -> !userFriendList.contains(person))
            .collect(Collectors.toList());
        if(userListSortedByScore.size()>5)
            return new ArrayList<>(userListSortedByScore.subList(0,5));
        return userListSortedByScore;
    }

    private static List<String> sortScoreMapByValue(Map<String, Integer> friendScoreMap) {
        return friendScoreMap.entrySet().stream()
            .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
            .filter(user -> user.getValue() != 0).map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    private static void addScoreVisitor(List<String> visitors, Map<String, Integer> friendScoreMap) {
        for (String visitor : visitors){
            if(friendScoreMap.containsKey(visitor))
                friendScoreMap.replace(visitor,friendScoreMap.get(visitor)+1);
            else
                friendScoreMap.put(visitor,1);
        }
    }

    private static void addScoreFriendsFriend(List<List<String>> friends, List<String> userFriendList,
        Map<String, Integer> friendScoreMap, String user) {
        for (List<String> friendRelation : friends) {
            if(Collections.disjoint(friendRelation, userFriendList) || friendRelation.contains(user))
                continue;
            addScoreFriendsFriend(userFriendList, friendScoreMap, friendRelation);
        }
    }

    private static void addScoreFriendsFriend(List<String> userFriendList, Map<String, Integer> friendScoreMap,
        List<String> friendRelation) {
        String friendFirst = friendRelation.get(0);
        String friendSecond = friendRelation.get(1);
        if(userFriendList.contains(friendFirst))
            friendScoreMap.replace(friendSecond,friendScoreMap.get(friendSecond)+10);
        else
            friendScoreMap.replace(friendFirst,friendScoreMap.get(friendFirst)+10);
    }

    private static void initFriendScoreMap(List<List<String>> friends, Map<String, Integer> friendScoreMap) {
        Set<String> userSet = friends.stream()
            .flatMap(List::stream).collect(Collectors.toSet());
        userSet.forEach(user -> friendScoreMap.put(user,0));
    }

    //리팩토링 할 수 있을 듯?
    private static void initUserFriendList(String user, List<List<String>> friends, List<String> userFriendList) {
        for (List<String> friendRelation : friends) {
            if(friendRelation.contains(user)){
                userFriendList.add(friendRelation.get(0));
                userFriendList.add(friendRelation.get(1));
                userFriendList.remove(user);
            }
        }
    }
}
