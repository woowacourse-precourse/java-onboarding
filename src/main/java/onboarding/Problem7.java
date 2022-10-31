package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    private final static int MAX_RECOMMEND_FRIENDS = 5;

    private static Map<String, Integer> preFriends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    /**
     * 유저 검증
     * @param user 유저 정보
     * @return 검증 결과
     */
    private static boolean validateUser(String user) {
        return Pattern.matches("^[a-z]{1,30}$", user);
    }

    /**
     * 등록된 예비 친구에게 점수 부여
     * @param user 유저 정보
     * @param point 추가할 점수
     */
    private static void addPreFriendPoint(String user, int point) {
        int previousPoint = getPreFriendsPoint(user);
        putPreFriendAndPoint(user, previousPoint + point);
    }

    /**
     * 추천 친구 구하기
     * @param maxRecommendFriends 최대 추천 친구
     * @return 추천 친구 목록
     */
    private static List<String> getTopPreFriends(int maxRecommendFriends) {
        Map<Integer, List<String>> pointAndUsers = new TreeMap<>((i, j) -> (j - i));
        List<String> topPreFriends = new ArrayList<>();

        for (Map.Entry<String, Integer> preFriend : preFriends.entrySet()) {
            String user = preFriend.getKey();
            int point = preFriend.getValue();

            List<String> friends = pointAndUsers.getOrDefault(point, new ArrayList<>());
            friends.add(user);

            pointAndUsers.put(point, friends);
        }

        int rotateKeyPointAndUsers = 0;

        for (int keyPointAndUsers : pointAndUsers.keySet()) {
            if (rotateKeyPointAndUsers >= maxRecommendFriends) {
                break;
            }

            List<String> users = pointAndUsers.get(keyPointAndUsers);
            users.sort(String.CASE_INSENSITIVE_ORDER);
            topPreFriends.addAll(users);

            rotateKeyPointAndUsers++;
        }

        return topPreFriends;
    }

    /**
     * 예비 친구 등록
     * @param user 유저 정보
     * @param point 기본 점수 설정
     */
    private static void putPreFriendAndPoint(String user, int point) {
        preFriends.put(user, point);
    }

    /**
     * 예비 친구 존재 여부 확인
     * @param user 유저 정보
     * @return 존재 여부
     */
    private static boolean existPreFriend(String user) {
        return preFriends.containsKey(user);
    }

    /**
     * 예비 친구의 점수 가져오기
     * @param user 유저 정보
     * @return 예비 친구의 점수
     */
    private static int getPreFriendsPoint(String user) {
        return preFriends.getOrDefault(user, 0);
    }
}
