package onboarding;

import java.util.List;
import java.util.NoSuchElementException;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //  유효성 검사
        if (!verifyInput(pobi)||!verifyInput(crong)) return -1;

        //  최대값 변수 설정
        int maxValuePobi = findMaxValueInList(pobi);
        int maxValueCrong = findMaxValueInList(crong);

        //  최대값 비교
        return compareValue(maxValuePobi, maxValueCrong);
    }

    //  입력값의 유효성 검사
    private static Boolean verifyInput(List<Integer> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i + 1) - input.get(i) != 1) return false;
        }
        return true;
    }

    //  입력된 두 숫자 비교
    private static int compareValue(int maxPobi, int maxCrong) {
        if (maxPobi == maxCrong) return 0;
        if (maxPobi > maxCrong) return 1;
        return 2;
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