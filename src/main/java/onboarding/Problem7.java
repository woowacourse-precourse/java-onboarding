package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> friendPoints = getFriendPoints(user, friends, visitors);
        List<Map.Entry<String, Integer>> sortedFriendPoints = sortFriendPoints(friendPoints);
        return getRecommendResult(sortedFriendPoints);
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

    private static Map<String, Integer> getFriendPoints(String user, List<List<String>> friends, List<String> visitors){
        // 친구 추천 점수를 계산하는 메소드
        Set<String> curFriends = getUserFriends(user, friends);
        Map<String, Integer> friendPoints = initFriendPoints(friends, visitors);

        // 함께 친구면 추천 점수 10 증가
        for (List<String> friend : friends){
            String leftFriend = friend.get(0);
            String rightFriend = friend.get(1);
            if (leftFriend.equals(user) || rightFriend.equals(user)){
                continue;
            }

            if (curFriends.contains(leftFriend)){
                friendPoints.put(rightFriend, friendPoints.get(rightFriend) + 10);
            }

            if (curFriends.contains(rightFriend)){
                friendPoints.put(leftFriend, friendPoints.get(leftFriend) + 10);
            }

        }

        // 방문자면 점수 1 증가
        for (String visitor : visitors){
            if (curFriends.contains(visitor)){
                continue;
            }
            friendPoints.put(visitor, friendPoints.get(visitor) + 1);
        }
        return friendPoints;
    }

    private static List<Map.Entry<String, Integer>> sortFriendPoints(Map<String, Integer> friendPoints){
        // (추천 점수, 친구 이름) 순으로 정렬하는 메소드
        List<Map.Entry<String, Integer>> sortedfriendPoints = new LinkedList<>(friendPoints.entrySet());
        sortedfriendPoints.sort(((o1, o2) -> {
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue() - o1.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }));
        return sortedfriendPoints;
    }

    private static List<String> getRecommendResult(List<Map.Entry<String, Integer>> sortedFriendPoints) {
        // 최대 5개 까지 친구 추천 목록을 생성해주는 메소드
        List<String> recommend = new ArrayList<>();
        for (Map.Entry<String, Integer> sortedFriendPoint : sortedFriendPoints) {
            if (sortedFriendPoint.getValue() == 0) {
                continue;
            } else {
                recommend.add(sortedFriendPoint.getKey());
            }

            if (recommend.size() == 5) {
                break;
            }
        }
        return recommend;
    }
}
