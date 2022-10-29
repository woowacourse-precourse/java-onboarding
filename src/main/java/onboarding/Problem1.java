package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 각 자리수를 더하는 함수
    public static Integer addDigits(Integer pageNum) {
        Integer value = 0;
        while (pageNum > 0) {
            value += pageNum % 10;
            pageNum /= 10;
        }
        return value;
    }

    // 각 자리수를 곱하는 함수
    public static Integer mulDigits(Integer pageNum) {
        Integer value = 1;
        while (pageNum > 0) {
            value *= pageNum % 10;
            pageNum /= 10;
        }
        return value;
    }

}