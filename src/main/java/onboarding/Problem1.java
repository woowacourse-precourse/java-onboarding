package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /*
        필요한 기능
        1. 각 자리별 숫자를 모두 더하는 메소드
        2. 각 자리별 숫자를 모두 곱하는 메소드
        3. 결과 비교를 위한 변수 하나씩
         */
        int pobi_sum = 0;   // 결과 비교용 변수
        int crong_sum = 0;  // 결과 비교용 변수

        for (int i = 0; i < 2; i++) {
            if (pobi_sum < addNumber(pobi[i])) {
                pobi_sum = addNumber(pobi[i]);
            }
            if (pobi_sum < multNumber(pobi[i])) {
                pobi_sum = multNumber(pobi[i]);
            }
        }

        for (int i = 0; i < 2; i++) {
            if (crong_sum < addNumber(crong[i])) {
                crong_sum = addNumber(crong[i]);
            }
            if (crong_sum < multNumber(crong[i])) {
                crong_sum = multNumber(crong[i]);
            }
        }

        if (pobi_sum > crong_sum) {
            answer = 1;
        } else if (pobi_sum < crong_sum) {
            answer = 2;
        } else if (pobi_sum == crong_sum) {
            answer = 0;
        } else {
            answer = -1;
        }

        return answer;
    }

    public static int addNumber(int a) {
        int sum = 0;
        for (; a > 0; a /= 10) {
            sum += a % 10;
        }
        return sum;
    }

    public static int multNumber(int a) {
        int sum = 1;
        for (; a > 0; a /= 10) {
            sum *= (a % 10);
        }
        return sum;
    }
}