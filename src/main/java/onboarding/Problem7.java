package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 기능 1
     * user의 친구 리스트 생성
     */
    public static List<String> makeFriendList(String user, List<List<String>> friends) {
        List<String> friendsOfUser = new ArrayList<>();

        for (int i = 0; i < friends.size(); i++) {
            if (friends.get(i).get(0).equals(user)) {
                friendsOfUser.add(friends.get(i).get(1));
            }
            if (friends.get(i).get(1).equals(user)) {
                friendsOfUser.add(friends.get(i).get(0));
            }
        }

        return friendsOfUser;
    }

    /**
     * 기능 2
     * 사용자와 함께 아는 친구를 가진 사람과 점수 Map 생성
     */
    public static HashMap<String, Integer> makeRecommendList(String user, List<String> friendsOfUser,
                                                             List<List<String>> friends) {

        HashMap<String, Integer> recommendNameWithScoreMap = new HashMap<>();

        for (int i = 0; i < friendsOfUser.size(); i++) {
            for (int j = 0; j < friends.size(); j++) {
                if (friends.get(j).get(0).equals(friendsOfUser.get(i)) && !friends.get(j).get(1).equals(user)) {
                    if (recommendNameWithScoreMap.containsKey(friends.get(j).get(1))) {
                        recommendNameWithScoreMap.put(friends.get(j).get(1), recommendNameWithScoreMap.get(friends.get(j).get(1)) + 10);
                    } else {
                        recommendNameWithScoreMap.put(friends.get(j).get(1), 10);
                    }
                }
                if (friends.get(j).get(1).equals(friendsOfUser.get(i)) && !friends.get(j).get(0).equals(user)) {
                    if (recommendNameWithScoreMap.containsKey(friends.get(j).get(0))) {
                        recommendNameWithScoreMap.put(friends.get(j).get(0), recommendNameWithScoreMap.get(friends.get(j).get(1)) + 10);
                    } else {
                        recommendNameWithScoreMap.put(friends.get(j).get(0), 10);
                    }
                }
            }
        }

        return recommendNameWithScoreMap;
    }

    /**
     * 기능 2에 만든 리스트에 방문자 리스트 및 점수 추가
     */
    public static HashMap<String, Integer> addVisitorScore(HashMap<String, Integer> recommendNameWithScoreMap, List<String> visitor) {

        for (int i = 0; i < visitor.size(); i++) {
            if (recommendNameWithScoreMap.containsKey(visitor.get(i))) {
                recommendNameWithScoreMap.put(visitor.get(i), recommendNameWithScoreMap.get(visitor.get(i)) + 1);
            } else {
                recommendNameWithScoreMap.put(visitor.get(i), 1);
            }
        }

        return recommendNameWithScoreMap;
    }


    /**
     * 기능 4
     * 점수가 높은 순서대로 정렬
     */

}
