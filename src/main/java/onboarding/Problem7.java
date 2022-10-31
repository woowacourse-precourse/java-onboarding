package onboarding;

import java.util.*;

public class Problem7 {

    // 친구관계 Map
    public static HashMap<String, List<String>> friendMap;
    // 친구추천 점수 Map
    public static HashMap<String, Integer> recommendScore;

    // 친구 관계 Map 생성
    public static void getFriendMap(List<List<String>> friends) {
        friendMap = new HashMap<>();

        for (List<String> friend : friends) {
            // 왼쪽 친구 <- 오른쪽 친구 관계 생성
            friendMap.put(friend.get(0), addFriend(friend.get(0), friend.get(1)));
            // 오른쪽 친구 <- 왼쪽 친구 관계 생성
            friendMap.put(friend.get(1), addFriend(friend.get(1), friend.get(0)));
        }
    }

    // 친구리스트에 친구 추가
    public static List<String> addFriend(String leftFrined, String rightFriend) {
        List<String> list = new ArrayList<>();
        if (friendMap.get(leftFrined) != null) list = friendMap.get(leftFrined);
        list.add(rightFriend);

        return list;
    }

    // 친구관계와 방문자리스트를 기반으로 친추추천점수 Map 생성
    public static void getRecommendScore(List<String> visitors, String user) {
        recommendScore = new HashMap<>();

        for (String userFriend : friendMap.get(user)) {
            for (String friend : friendMap.get(userFriend)) {
                if (!isFriend(user, friend)) {
                    recommendScore.put(friend, recommendScore.getOrDefault(recommendScore.get(friend), 0) + 10);
                }
            }
        }

        for (String visitor : visitors) {
            if (!isFriend(user, visitor)) {
                recommendScore.put(visitor, recommendScore.getOrDefault(recommendScore.get(visitor), 0) + 1);
            }
        }
    }

    // 이미 친구 관계인지 판별
    public static boolean isFriend(String user, String target) {
        // 친구 관계 => true, 아니면 false 리턴

        // 본인일 시
        if (user.equals(target)) return true;
        // 이미 친구관계일 시
        if (friendMap.get(user).contains(target)) return true;

        return false;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> recommendList;

        // 친구 관계 생성
        getFriendMap(friends);
        // 친구추천 점수 Map 생성
        getRecommendScore(visitors, user);

        recommendList = new ArrayList<>(recommendScore.keySet());
        // 점수 기준 내림차순 정렬
        recommendList.sort((o1, o2) -> {
            // 점수가 같을 시 이름으로 오름차 정렬
            if (recommendScore.get(o1).equals(recommendScore.get(o2))) return o1.compareTo(o2);
            return recommendScore.get(o2) - recommendScore.get(o1);
        });

        List<String> answer = new ArrayList<>();

        int cnt = 0; // 최대 5개 추천 조건 카운팅
        for (String friend : recommendList) {
            if (cnt < 5) answer.add(friend);
        }

        return answer;
    }
}
