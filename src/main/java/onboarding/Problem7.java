package onboarding;

import java.util.*;

public class Problem7 {

    private static final int MAX_RETURN_SIZE = 5;
    private static final int KNOW_WITH_USER = 10;
    private static final int VISIT_TIIMELIME_SCORE = 1;
    private static final int EXCEPTION = -1;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>(Collections.emptyList());
        Map<String, Integer> map = new HashMap<>(); // [이름, 점수]
        Set<String> not_yet_friend = new HashSet<>(); // 사용자와 친구가 아닌 유저들
        Set<String> already_friend = new HashSet<>(); // 사용자와 이미 친구인 유저들
        return answer;
    }

    /*
     * 기능 요구 사항
     * 1. 제한사항을 잘 지켯는지 체크하기
     * */

    private static Integer check_compliance(String user, List<List<String>> friends, List<String> visitors) {
        if (!user_range_valid(user)) {
            return EXCEPTION;
        }
        if (!friend_range_valid(friends)) {
            return EXCEPTION;
        }
        if (!id_range_valid(friends)) {
            return EXCEPTION;
        }
        if (!visitors_range_valid(visitors)) {
            return EXCEPTION;
        }
        if (!id_lower_valid(friends)) {
            return EXCEPTION;
        }
        return 0;
    }

    // user 의 길이가 1 이상, 30 이하가 아닌 경우, 예외 반환
    private static boolean user_range_valid(String user) {
        if (user.length() < 1 || user.length() > 30) {
            return false;
        }
        return true;
    }

    // friends 의 길이가 1 이상 10,000 이하가 아닌 경우 예외 반환
    private static boolean friend_range_valid(List<List<String>> friends) {
        if (friends.size() < 1 || friends.size() > 10000) {
            return false;
        }
        return true;
    }

    // 사용자 아이디의 길이가 1 이상 30 이하가 아닌 경우 예외 반환
    private static boolean id_range_valid(List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String id : friend) {
                if (id.length() < 1 || id.length() > 30) {
                    return false;
                }
            }
        }
        return true;
    }

    // visitors 의 길이가 0 이상 10,000 이하가 아닌 경우 예외 반환
    private static boolean visitors_range_valid(List<String> visitors) {
        if (visitors.size() > 10000) {
            return false;
        }
        return true;
    }

    // 사용자 아이디가 알파벳 소문자로만 이루어져 있지 않은 경우 예외 반환
    private static boolean id_lower_valid(List<List<String>> friends) {
        for (List<String> friend : friends) {
            for (String id : friend) {
                if (!id.equals(id.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }


    /*
     * 기능 요구 사항
     * 2. 추천 점수 계산하기
     * */

    private static void recommend_score(List<List<String>> friends, List<String> visitors,
                                        Map<String, Integer> map, Set<String> not_yet_friend, Set<String> already_friend) {

        // 사용자와 함께 아는 친구 수 * 10점
        for (List<String> friendList : friends) {
            for (String friend : already_friend) {
                if (friendList.contains(friend)) {  // 사용자와 함께 아는 친구가 있으면
                    String friend_a = friendList.get(0); // friend 리스트의 첫 번째 요소
                    String friend_b = friendList.get(1); // friend 리스트의 두 번째 요소
                    if (not_yet_friend.contains(friend_a)) {
                        map.put(friend_a, map.get(friend_a) + KNOW_WITH_USER); // friend_a 의 점수 + 10
                    }
                    if (not_yet_friend.contains(friend_b)) { // user 일수 있기 때문에 if-else가 아닌 if문 두번 사용
                        map.put(friend_b, map.get(friend_b) + KNOW_WITH_USER); // friend_b 의 점수 + 10
                    }
                }
            }
        }

        // 유저의 타임라인에 방문한 횟수 * 1점
        for (String visitor : visitors) {
            if (not_yet_friend.contains(visitor)) {
                map.put(visitor, map.get(visitor) + VISIT_TIIMELIME_SCORE); // visitor 의 점수 + 1
            }
        }
    }

    /*
     * 기능 요구 사항
     * 3. 친구 점수를 계산해야 하는 사람만 존재하도록 not_yet_friend를 초기화 하기
     * 사용자 본인이거나, 이미 친구인 사람들은 친구 점수를 계산X
     * 사용자 본인 혹은, 이미 친구인 사람들은 already_friend 에 담음
     * */


    /*
     * 기능 요구 사항
     * 4. 점수 순으로 정렬하고, 추천 점수가 같은 경우, 이름순으로 정렬
     * 최대 5명만 리턴할 것.
     * */


}
