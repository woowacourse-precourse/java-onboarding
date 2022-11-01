package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = makeUserFriends(user, friends);
        Map<String, Integer> recommendedFriendScore = calculateRecommendedFriendScore(userFriends, user, friends, visitors);

        List<String> answer = Collections.emptyList();
        return answer;
    }

    //user의 친구들의 리스트를 반환
    public static List<String> makeUserFriends(String user, List<List<String>> friends) {
        List<String> userFriends = new ArrayList<>();

        for (List<String> friend : friends) {
            //user와 친구인 경우
            if (friend.get(0).equals(user)) {
                userFriends.add(friend.get(1));
            } else if (friend.get(1).equals(user)) {
                userFriends.add(friend.get(0));
            }
        }

        return userFriends;
    }

    public static Map<String, Integer> calculateRecommendedFriendScore(List<String> userFriends, String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendedFriendScore = new HashMap<>();

        // 함께 하는 친구 10점 더하기
        for (List<String> friend : friends) {
            // user친구와 아는 사이일 때
            // 그 친구가 나 이면 안된다.
            // 이미 친구사이면 추천하지 않는다.
            if (userFriends.contains(friend.get(0)) && friend.get(1).equals(user) == false && userFriends.contains(friend.get(1)) == false) {
                //이미 있는 친구면 10점 더하기
                if (recommendedFriendScore.containsKey(friend.get(1)) == true) {
                    recommendedFriendScore.put(friend.get(1), recommendedFriendScore.get(friend.get(1)) + 10);
                }

                //없는 친구면 10점으로 저장
                else {
                    recommendedFriendScore.put(friend.get(1), 10);
                }
            } else if (userFriends.contains(friend.get(1)) && friend.get(0).equals(user) == false && userFriends.contains(friend.get(0)) == false) {
                //이미 있는 친구면 10점 더하기
                if (recommendedFriendScore.containsKey(friend.get(0)) == true) {
                    recommendedFriendScore.put(friend.get(0), recommendedFriendScore.get(friend.get(0)) + 10);
                }

                //없는 친구면 10점으로 저장
                else {
                    recommendedFriendScore.put(friend.get(0), 10);
                }
            }
        }

        for (String visitor : visitors) {

            // 이미 내 친구들인 경우 추천하지 않는다.
            if (userFriends.contains(visitor)) {
                continue;
            }

            // 내가 나를 방문한 경우에도 추천하지 않는다.
            if (user.equals(visitor)) {
                continue;
            }

            //이미 있는 친구면 1점 더하기
            if (recommendedFriendScore.containsKey(visitor) == true) {
                recommendedFriendScore.put(visitor, recommendedFriendScore.get(visitor) + 1);
            }

            //없는 친구면 1점으로 저장
            else {
                recommendedFriendScore.put(visitor, 1);
            }

        }

        return recommendedFriendScore;
    }
}
