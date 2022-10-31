package onboarding;

import java.util.*;

/**
 *  구현할 기능 목록
 *      1.  사용자와 함께 아는 친구의 수에 따라 10점 추가하는 기능
 *          1.1. 친구 관계 구하는 기능
 *          1.2. 사용자와 친구면 계산하지 않는다.
 *          1.3. 사용자 친구의 친구면 10점 추가
 *
 *      2. 사용자의 타임 라인에 방문한 횟수에 따라 1점 추가하는 기능
 *          2.1. 사용자와 친구면 계산하지 않는다.
 *          2.2. 방문자이면 1점 추가
 *
 *      3. 점수가 높은 최대 5명까지 추천하는 기능
 *          3-1. 추천 점수가 같은 경우 이름순으로 정렬
 *          3-2. 최대 5명까지 추천
 */

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //사용자와 친구 관계 구하기
        Set<String> friendSet;
        friendSet = getFriendSet(user, friends);

        // 사용자와 함께 아는 친구의 수에 따라 10점 추가
        Map<String, Integer> recommendMap = new HashMap<>();
        recommendByFriendSet(user, friends, recommendMap, friendSet);

        // 사용자의 타임 라인에 방문한 횟수에 따라 1점 추가하는 기능
        recommendByVisitors(visitors, friendSet, recommendMap);

        // 점수가 높은 최대 5명까지 추천
        sortRocommendation(answer, recommendMap,5);

        return answer;
    }

    // 사용자와 친구 관계 구하기
    private static Set<String> getFriendSet(String user, List<List<String>> friends) {
        Set<String> friendSet = new HashSet<>();

        for (List<String> friend : friends) {
            if (user.equals(friend.get(0))) {
                friendSet.add(friend.get(1));
            } else if (user.equals(friend.get(1))) {
                friendSet.add(friend.get(0));
            }
        }
        return friendSet;
    }

    // 사용자와 함께 아는 친구의 수에 따라 10점 추가
    private static void recommendByFriendSet(String user, List<List<String>> friends, Map<String, Integer> recommendMap, Set<String> friendSet) {

        for (List<String> friend : friends) {
            //사용자와 친구면 계산하지 않는다.
            if (user.equals(friend.get(0)) || user.equals(friend.get(1))) {
                continue;
            }
            if(friendSet.contains(friend.get(0))){
                if (recommendMap.containsKey(friend.get(1))) {
                    recommendMap.put(friend.get(1), recommendMap.get(friend.get(1)) + 10);
                } else {
                    recommendMap.put(friend.get(1), 10);
                }
            }
            if(friendSet.contains(friend.get(1))){
                if (recommendMap.containsKey(friend.get(0))) {
                    recommendMap.put(friend.get(0), recommendMap.get(friend.get(0)) + 10);
                } else {
                    recommendMap.put(friend.get(0), 10);
                }
            }

        }
    }

    // 사용자의 타임 라인에 방문한 횟수에 따라 1점 추가
    private static void recommendByVisitors(List<String> visitors, Set<String> friendSet, Map<String, Integer> recommendMap) {

        for (String visitor : visitors) {

            //사용자와 친구면 계산하지 않는다.
            if (friendSet.contains(visitor)) {
                continue;
            }

            if (recommendMap.containsKey(visitor)) {
                recommendMap.put(visitor, recommendMap.get(visitor) + 1);
            } else {
                recommendMap.put(visitor, 1);
            }
        }

    }

    // 점수가 높은 최대 5명까지 추천하는 기능
    private static void sortRocommendation(List<String> answer, Map<String, Integer> recommendMap, int limit) {
        // 추천 점수가 같은 경우 이름순으로 정렬
        List<String> keySet = new ArrayList<>(recommendMap.keySet());
        keySet.sort((o1, o2) -> recommendMap.get(o2).compareTo(recommendMap.get(o1)));


        for (String key : keySet) {
            // 최대 5명까지 추천
            if (answer.size() <= limit) {
                answer.add(key);
            }
        }
    }

}
