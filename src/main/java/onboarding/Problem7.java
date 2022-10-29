package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    private static Set<String> getUserFriends(String user, List<List<String>> friends){
        // 사용자의 친구를 찾아주는 메소드
        Set<String> userFriends = new HashSet<>();
        for (List<String> friend : friends){
            String leftFriend = friend.get(0);
            String rightFriend = friend.get(1);
            if (leftFriend.equals(user)){
                userFriends.add(rightFriend);
            }
            if (rightFriend.equals(user)){
                userFriends.add(leftFriend);
            }

        }
        return userFriends;
    }

    private static Set<String> getAllNames(List<List<String>> friends, List<String> visitors){
        // 모든 이름을 찾는 메소드
        Set<String> allNames = new HashSet<>();
        for (List<String> friend : friends){
            allNames.add(friend.get(0));
            allNames.add(friend.get(1));
        }

        for (String visitor : visitors){
            allNames.add(visitor);
        }
        return allNames;
    }
    private static Map<String, Integer> initFriendPoints(List<List<String>> friends, List<String> visitors){
        // 모든 친구의 추천 점수를 초기화 해주는 메소드
        Map<String, Integer> friendPoints = new HashMap<>();
        Set<String> allNames = getAllNames(friends, visitors);

        for (String allName : allNames){
            friendPoints.put(allName, 0);
        }
        return friendPoints;
    }
}
