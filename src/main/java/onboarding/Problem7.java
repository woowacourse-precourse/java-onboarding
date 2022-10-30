package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        Set<String> friendSet = new HashSet<>(); // 전체 친구들이 담긴 Set
        Map<String, Set<String>> friendMap = new HashMap<>();  // 친구목록

        makeFriendSet(friends, friendSet);
        makeFriendMap(friends, friendSet, friendMap);
        return answer;
    }

    /**
     * friendSet 초기화 : 기능 목록 1 */
    private static void makeFriendSet(List<List<String>> friends, Set<String> friendSet) {
        for (List<String> friend : friends) {
            friendSet.add(friend.get(0));
            friendSet.add(friend.get(1));
        }
    }

    /**
     * friendMap 초기화 : 기능 목록 1
     * * */
    private static void makeFriendMap(List<List<String>> friends, Set<String> friendSet, Map<String, Set<String>> friendMap) {
        for (List<String> friend : friends) {
            Set<String> temp1 = friendMap.getOrDefault(friend.get(0), new HashSet<>());
            Set<String> temp2 = friendMap.getOrDefault(friend.get(1), new HashSet<>());
            
            temp1.add(friend.get(1));
            temp2.add(friend.get(0));

            friendMap.put(friend.get(0), temp1);
            friendMap.put(friend.get(1), temp2);
        }
    }

}
