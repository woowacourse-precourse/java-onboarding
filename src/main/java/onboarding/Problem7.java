package onboarding;

import java.util.*;

public class Problem7 {
    private static HashSet<String> allFriends = new HashSet<>();
    private static HashSet<String> alreadyFriends = new HashSet<>();
    private static HashSet<String> notFriends = new HashSet<>();
    private static HashMap<String, Integer> notFriends_Score = new HashMap<>();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer;

        //이미 친구인 경우와 아닌 경우로 분류하는 기능
        categorizeFriends(user, friends);

        //사용자와 함께 아는 친구 점수 계산 기능
        calculateAcquaintanceScore(friends);

        //방문 횟수 점수 계산 기능
        calculateVisitScore(visitors);

        //최종 점수 기준으로 내림차순 정렬, 점수가 같을 경우 이름 순으로 오름차순 정렬 후 최대 5명까지만 반환하는 기능
        answer = sortMapByValue(notFriends_Score);

        return answer;
    }
}
