package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        // 사용자와 함께 아는 친구의 수 = 10점
        // 사용자의 타임 라인에 방문한 횟수 = 1점

        // friends에 저장되어 있는 각각의 유저마다 친구 목록을 HashMap으로 생성 (key : username / value : 친구 목록(List<String>))

        // 점수 목록을 HashMap으로 생성 (key : username / value : 점수 (0으로 초기화))
        // 1. friends에 들어있는 유저에 대한 entity 생성
        // 2. friends에 들어있지 않으며, visitors에만 들어있는 유저에 대한 entity 생성

        // 각각의 유저에 대한 점수 계산
        // 1. 사용자와 함께 아는 친구의 수 = 10점
        // 2. 사용자의 타임 라인에 방문한 횟수 = 1점

        // 점수가 가장 높은 순으로 정렬하여 최대 5명을 뽑음
        // 유의사항
        // 1. 이미 user의 친구인 경우에는 추천하지 않음
        // 2. 추천 점수가 0점인 경우 추천하지 않음
        // 3. 추천 점수가 같은 경우는 이름순으로 오름차순 정렬

        return answer;
    }

}
