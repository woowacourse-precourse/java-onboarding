package onboarding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/** 추천 친구 목록을 정렬하기 위한 클래스 */
class RecommendedFriendComparator implements Comparator<String> {
    Map<String, Integer> recommendedFriend = Collections.EMPTY_MAP;
    RecommendedFriendComparator(Map<String, Integer> recommendedFriend){
        this.recommendedFriend = recommendedFriend;
    }

    /**
     * 추천 점수를 기준으로 내림차순 정렬 수행, 추천 점수가 같다면 추천 친구명 사전순으로 오름차순 수행
     * @param leftUser 비교할 첫 번째 유저
     * @param rightUser 비교할 두 번째 유저
     */
    @Override
    public int compare(String leftUser, String rightUser) {
        Integer LeftPoint = recommendedFriend.get(leftUser);
        Integer RightPoint = recommendedFriend.get(rightUser);
        if (LeftPoint.equals(RightPoint)) {
            return leftUser.compareTo(rightUser);
        }
        return RightPoint.compareTo(LeftPoint);
    }
}

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
