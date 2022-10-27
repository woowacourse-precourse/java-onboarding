package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*
        필요한 기능
        1. 책 페이지 (3~398) 랜덤 호출
        2. 홀수일 경우: +1, 짝수일 경우: -1
        3. 각 자리별 숫자를 모두 더하는 함수
        4. 각 자리별 숫자를 모두 곱하는 함수
        5. 결과 비교를 위한 변수 하나씩
         */


        return answer;
    }

    public static void randomPage(List<Interger> person) {
        // 책 페이지 랜덤 호출 (1, 2, 399, 400 페이지 제외)
        person[0] = (int)(Math.random() * 395 + 3);
        if (person[0] / 2 != 0) {
            person[1] = person[0] + 1;
        }
        else {
            person[1] = person[0];
            person[0] -= 1;
        }
    }
}