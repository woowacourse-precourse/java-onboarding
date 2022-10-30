package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        List<String> userFriendList = new ArrayList<>();
        Map<String,Integer> friendScoreMap = new HashMap<>();

        initUserFriendList(user, friends, userFriendList);
        initFriendScoreMap(friends, friendScoreMap);

        addScoreInScoreMap(friends, userFriendList, friendScoreMap);

        return answer;
    }

    private static void addScoreInScoreMap(List<List<String>> friends, List<String> userFriendList,
        Map<String, Integer> friendScoreMap) {
        for (List<String> friendRelation : friends) {
            if(Collections.disjoint(friendRelation, userFriendList))
                continue;
            addScoreInScoreMap(userFriendList, friendScoreMap, friendRelation);
        }
    }

    private static void addScoreInScoreMap(List<String> userFriendList, Map<String, Integer> friendScoreMap,
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
