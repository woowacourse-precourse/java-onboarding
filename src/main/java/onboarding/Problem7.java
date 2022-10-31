package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    private static HashMap<String, Integer> preFriends = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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
