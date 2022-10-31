package onboarding;

import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //  List로 주어진 입력값에 대한 최대값 계산
    private static int findMaxValueInList(List<Integer> input) {
        return input.stream().map(Problem1::findMaxValueInNum).max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }

    //  자릿수별 덧셈연산, 곱셈연산된 숫자 중 최대값 계산
    private static int findMaxValueInNum(int num) {
        return Math.max(valueByPlus(num), valueByMultiple(num));
    }

    //  입력된 수의 자릿수별 덧셈연산
    private static int valueByPlus(int num) {
        int result = num % 10;
        while (num >= 10) {
            num /= 10;
            result += num % 10;
        }
        return result;
    }

    //  입력된 수의 자릿수별 곱셈연산
    private static int valueByMultiple(int num) {
        int result = num % 10;
        while (num >= 10) {
            num /= 10;
            result *= num % 10;
        }
        return result;
    }
}