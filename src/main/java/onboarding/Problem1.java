package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*
        1. 예외처리
        - 배열 길이가 2가 아닌 경우
        - 두 페이지 관계가 x, x+1이 아닐 경우
        - x가 짝수인 경우
        - x<1 또는 x>400인 경우
         */

        /*
        2. 포비와 크롱의 max 점수 구하기
        - 각각의 max 점수: max(max(왼쪽 페이지 자릿수 합, 왼쪽 페이지 자릿수 곱), max(오른쪽 페이지 자릿수 합, 오른쪽 페이지 자릿수 곱))
         */

        /*
        3. 게임 결과 구하기
        - 포비가 이기면 1
        - 비기면 0
        - 크롱이 이기면 2
         */
        return answer;
    }
}