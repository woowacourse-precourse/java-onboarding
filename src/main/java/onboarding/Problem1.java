package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // int -> int[] 변환 후 리턴
    private static int[] changeArray(int input) {
        int[] digits = Stream.of(String.valueOf(input).split(""))
                .mapToInt(Integer::parseInt).toArray();
        return digits;
    }

    // 페이지 숫자를 더하는 함수
    private static int plusNumber(int input) {
        int[] digits = changeArray(input);
        int result = 0;
        for(int i = 0; i<digits.length; i++) {
            result += digits[i];
        }

        return result;
    }

    // 페이지 숫자를 곱하는 함수
    private static int multiplyNumber(int input) {
        int[] digits = changeArray(input);
        int result = 1;
        for(int i = 0; i<digits.length; i++) {
            result *= digits[i];
        }

        return result;
    }

    // 더 큰 수 리턴하는 함수
    private static int maxNumber(int plus, int multiply) {
        if(plus < multiply) {
            return multiply;
        }
        return plus;
    }
}