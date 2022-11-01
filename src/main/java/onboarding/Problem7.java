package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    static Map<String, List<String>> friendsMap = new HashMap<>();
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {

        List<String> userFriend = makeUserFriends(user, friends);
        Map<String, Integer> recommendList = makeRecommendList(user, friends, userFriend);
        addVisitorsScore(recommendList, userFriend, visitors);
        List<String> answer = makeResult(recommendList);
        return answer;
    }
    private static List<String> makeUserFriends(String user, List<List<String>> friends) {
        List<String> userFriend = new ArrayList<>();
        for(List<String> friend : friends) {
            if(friend.contains(user)) {
                for (int i = 0; i < 2; i++) {
                    if(!friend.get(i).equals(user)) {
                        userFriend.add(friend.get(i));
                    }
                }
            }
        }
        return userFriend;
    }
    private static Map<String, Integer> makeRecommendList(String user, List<List<String>> friends, List<String> userFriend) {
        Map<String, Integer> recommendList = new HashMap<>();
        //user 가 아니고, user 친구가 아닌 사람들
        for(List<String> friend : friends) {
            for(String name : userFriend) {
                if(friend.contains(name) && !friend.contains(user)) {
                    for (int i = 0; i < 2; i++) {
                        if(!friend.get(i).equals(name)) {
                            recommendList.put(friend.get(i), recommendList.getOrDefault(friend.get(i), 10) + 10);
                        }
                    }
                }
            }
        }
        return recommendList;
    }

    private static void addVisitorsScore(Map<String, Integer> recommendList, List<String> userFrined, List<String> visitors) {
        for(String visitor : visitors) {
            if(!userFrined.contains(visitor)) {
                recommendList.put(visitor, recommendList.getOrDefault(visitor, 1) + 1);
            }
        }
    }
    private static List<String> makeResult (Map<String, Integer> recommendList) {
        return recommendList.keySet().stream().sorted((o1, o2) -> {
            if (recommendList.get(o1) > recommendList.get(o2)) {
                return -1;
            } else if (recommendList.get(o1) < recommendList.get(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        }).limit(5).collect(Collectors.toList());
    }
}