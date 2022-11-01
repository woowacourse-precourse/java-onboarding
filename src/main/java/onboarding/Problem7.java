package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> userFriends = makeUserFriends(user, friends);
        Map<String, Integer> recommendedFriendScore = calculateRecommendedFriendScore(userFriends, user, friends, visitors);

        List<String> recommendList = new ArrayList<>(recommendedFriendScore.keySet());

        // 점수가 높은 순으로 정렬하고, 점수가 같으면 이름순으로 정렬
        recommendList.sort((o1, o2) -> {
            if (recommendedFriendScore.get(o1) > recommendedFriendScore.get(o2)) {
                return -1;
            } else if (recommendedFriendScore.get(o1) < recommendedFriendScore.get(o2)) {
                return 1;
            } else { // o1과 o2의 점수가 같으면 이름순
                return o1.compareTo(o2);
            }
        });

        // 최대 5명만 추천
        List<String> answer = recommendList.stream().limit(5).collect(Collectors.toList());

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

    //이름별로 추천친구 점수를 Mapping하여 반환
    public static Map<String, Integer> calculateRecommendedFriendScore(List<String> userFriends, String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Integer> recommendedFriendScore = new HashMap<>();

        // 함께 하는 친구 10점 더하기
        for (List<String> friend : friends) {
            // B가 함께 아는 친구일 경우
            if (checkFriendsWeKnow(userFriends, user, friend.get(0), friend.get(1))) {
                //이미 있는 친구면 10점 더하기
                if (recommendedFriendScore.containsKey(friend.get(1)) == true) {
                    recommendedFriendScore.put(friend.get(1), recommendedFriendScore.get(friend.get(1)) + 10);
                }

                //없는 친구면 10점으로 저장
                else {
                    recommendedFriendScore.put(friend.get(1), 10);
                }
            } else if (checkFriendsWeKnow(userFriends, user, friend.get(1), friend.get(0))) { // A가 함께아는 친구일 경우
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

    //함께아는 친구인지 확인
    // user친구와 아는 사이일 때
    // 그 친구가 나 이면 안된다.
    // 이미 친구사이면 추천하지 않는다.
    public static boolean checkFriendsWeKnow(List<String> userFriends, String user, String friendA, String friendB) {
        return userFriends.contains(friendA) && friendB.equals(user) == false && userFriends.contains(friendB) == false;
    }
}
