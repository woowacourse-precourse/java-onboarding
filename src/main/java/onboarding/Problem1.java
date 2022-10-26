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

    // 예외처리 함수
    private static boolean checkNumber(List<Integer> input) {
        // 왼쪽 페이지 홀수
        boolean oddNum = input.get(0)%2 != 0;
        // 오른쪽 페이지 짝수
        boolean evenNum = input.get(1)%2 == 0;
        // 오른쪽 페이지 - 왼쪽 페이지 가 1 인지
        boolean checkNum = (input.get(1) - input.get(0)) == 1;
        // 시작면 or 마지막면 아닌지
        boolean checkPage = (input.get(0) > 0 && input.get(1) < 401);

        if(oddNum && evenNum && checkNum && checkPage) {
            return true;
        }
        return false;
    }
}