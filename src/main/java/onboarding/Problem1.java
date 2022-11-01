package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외사항
        if ((pobi.size() > 2) || (crong.size() > 2) || (pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1) ||
                (pobi.get(0) == 1) || (pobi.get(1) == 400) || (crong.get(0) == 1) || (crong.get(1) == 400)) {
            return -1;
        }

        int answer;
        int pobi_sum = comparison(pobi);   // 결과 비교 변수
        int crong_sum = comparison(crong);  // 결과 비교 변수

        // 최종 비교 후 answer 값 반환
        if (pobi_sum > crong_sum) {
            answer = 1;
        } else if (pobi_sum < crong_sum) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    // 각 자리 숫자를 모두 더하는 메서드
    public static int addNumber(int a) {
        int sum = 0;
        for (; a > 0; a /= 10) {
            sum += a % 10;
        }
        return sum;
    }

    // 각 자리 숫자를 모두 곱하는 메서드
    public static int multNumber(int a) {
        int sum = 1;
        for (; a > 0; a /= 10) {
            sum = sum * (a % 10);
        }
        return sum;
    }

    // 결과 비교 메서드
    public static int comparison(List<Integer> person) {
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            if (sum < addNumber(person.get(i))) {
                sum = addNumber(person.get(i));
            }
            if (sum < multNumber(person.get(i))) {
                sum = multNumber(person.get(i));
            }
        }
        return sum;
    }
}