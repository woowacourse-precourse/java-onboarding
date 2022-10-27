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
        4. 예외사항: 연속된 쪽수가 아닌 경우 / 1쪽이나 400 쪽이 나온 경우
         */
        if ((pobi.length > 2) || (crong.length > 2)) {
            return -1;
        } else if ((pobi[1] - pobi[0] != 1) || (crong[1] - pobi[0] != 0) || ) {
            return -1;
        } else if ((pobi[0] == 1) || (pobi[1] == 400) || (crong[0] == 1) || (crong[1] == 400)) {
            return -1;
        }

        int pobi_sum = comparison(pobi);   // 결과 비교용 변수
        int crong_sum = comparison(crong);  // 결과 비교용 변수

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
            sum += (int)(a % 10);
        }
        return sum;
    }

    public static int multNumber(int a) {
        int sum = 1;
        for (; a > 0; a /= 10) {
            sum = (int)(sum * (a % 10));
        }
        return sum;
    }

    public static int comparison(List<Integer> person) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            if (sum < addNumber(person[i])) {
                sum = addNumber(person[i]);
            }
            if (sum < multNumber(person[i])) {
                sum = multNumber(person[i]);
            }
        }
        return sum;
    }
}