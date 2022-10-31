package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        answer = recommendList(user, friends, visitors);
        return answer;
    }

    private static List<String> recommendList(String user,List<List<String>> friends ,List<String> visitors) {

        Map<String , Set<String>> friendMap = getFriendsMap(friends);
        Map<String , Integer> recommendScoreMap = new HashMap<>();

        setFriendsScore(user, friendMap, recommendScoreMap);
        setVisitorScore(visitors, recommendScoreMap);
        deleteUserFriends(user ,friendMap, recommendScoreMap);

        // 추천 점수 정보맵으로 추천 친구 리스트를 받아옴
        List<String> result = recommendListByScoreMap(recommendScoreMap);

        return result;
    }
}
