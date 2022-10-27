package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*
        필요한 기능
        1. 각 자리별 숫자를 모두 더하는 함수
        2. 각 자리별 숫자를 모두 곱하는 함수
        3. 결과 비교를 위한 변수 하나씩
         */

        return answer;
    }

    public static int addNumber(int a) {
        int sum = 0;
        for (; a > 0; a /= 10) {
            sum += a % 10;
        }
        return sum;
    }
}