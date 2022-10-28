package onboarding;

import java.util.*;

/*
    요구사항 분석
    사용자와 함꼐 아는 친구의 수 = 10점 -> friends 에 user가 들어가 있는 경우 해당 친구에 10점 부여
    사용자의 타임라인에 방문한 횟수 = 1점 -> visitor에 들어가 있는 사람에 1점씩부여

    추천점수가 0인 경우 제외, 점수가 같은 경우 이름순으로 정렬

    제한사항
    동일한 친구 관계가 중복해서 주어지지 않는다. (A ,B) , (B, A) => X
    추천할 친구가 없는 경우는 없다

    프로그램 구현
    Map 자료구조를 사용하여 해당 이름에 대한 점수 부여할것
    Step1. Map 자료구조 만들기
    Step2. friends를 탐색하며 user가 들어가있는 경우 친구 이름을 Map 넣고 점수 10점 부여
    Step3. visitors 를 탐색하며 해당 친구이름을 Map 에 넣고 1점부여
    Step4. Map을 value 기준 오름차순 정렬 -> 점수가 같은 경우 이름순으로 정렬
    Step5. 위에서 부터 하나씩 answer에 넣되 점수가 0인 경우에는 넣지 않고, answer 리턴
 */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        //Step1. Map 자료구조 만들기
        Map<String, Integer> recommendPoint = new HashMap<>();

        //Step2. friends를 탐색하며 user가 들어가있는 경우 친구 이름을 Map 넣고 점수 10점 부여
        for (List<String> friend : friends) {
            scoreFriendPoint(recommendPoint, friend, user);
        }
        //Step3. visitors 를 탐색하며 해당 친구이름을 Map 에 넣고 1점부여
        for (String visitor : visitors) {
            scoreVisitorPoint(recommendPoint, visitor);
        }

        return answer;
    }

    private static void scoreVisitorPoint(Map<String, Integer> recommendRank, String visitor) {

        recommendRank.put(visitor, recommendRank.getOrDefault(visitor, 0) + 1);
    }

    private static void scoreFriendPoint(Map<String, Integer> recommendRank, List<String> friend, String user) {

        String friendName1 = friend.get(0);
        String friendName2 = friend.get(1);

        if (friendName1.equals(user)) {
            recommendRank.put(friendName2, recommendRank.getOrDefault(friendName2, 0) + 10);
        } else if (friendName2.equals(user)) {
            recommendRank.put(friendName1, recommendRank.getOrDefault(friendName1, 0) + 10);
        }
    }

}
