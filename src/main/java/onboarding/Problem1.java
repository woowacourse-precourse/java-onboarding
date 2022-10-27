package onboarding;

import java.util.List;

import static java.lang.Integer.MIN_VALUE;
import static onboarding.Problem1.Constants.*;

class Problem1 {

    static class Constants {
        public static final int FIRST_PAGE = 0;
        public static final int LAST_PAGE = 400;
        public static final int LEFT_PAGE = 0;
        public static final int RIGHT_PAGE = 1;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 처리
        if (validateList(pobi) || validateList(crong)) {
            return -1;
        }

        // pobi 페이지들의 최댓값
        int pobiMax = compareNumbers(pobi);
        // crong 페이지들의 최댓값
        int crongMax = compareNumbers(crong);

        if (crongMax == pobiMax) {
            return 0;
        } else if (pobiMax > crongMax) {
            return 1;
        } else { // 남은 경우의 수는 crong이 값이 큰 경우이기 때문에 return 2;
            return 2;
        }

    }

    // 예외 발생시 TRUE
    private static boolean validateList(List<Integer> list) {
        // 페이지는 null 값이 들어갈 수 없다.
        if (list.get(LEFT_PAGE) == null || list.get(RIGHT_PAGE) == null) {
            return true;
        }

        // 왼쪽 페이지는 0 이상 400이하의 값이여야한다.
        if (list.get(LEFT_PAGE) <= FIRST_PAGE || list.get(LEFT_PAGE) >= LAST_PAGE){
            return true;
        }

        // 오른쪽 페이지는 0 이상 400이하의 값이어야한다.
        if (list.get(RIGHT_PAGE) <= FIRST_PAGE || list.get(RIGHT_PAGE) >= LAST_PAGE) {
            return true;
        }

        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야한다.
        if (list.get(LEFT_PAGE) % 2 != 1 || list.get(RIGHT_PAGE) % 2 != 0) {
            return true;
        }

        // 배열의 길이는 2여야 한다.
        if (list.size() != 2) {
            return true;
        }

        return list.get(RIGHT_PAGE) - list.get(LEFT_PAGE) != 1;
    }

    // 4개의 경우의 수 (왼쪽 페이지 각 자릿수 더하고 곱하고, 오른쪽 페이지 각 자릿수 더하고 곱하고) 중에서
    // 가장 큰 값을 반환하는 메서드
    private static int compareNumbers(List<Integer> numbers) {
        int addNum, multiNum;
        int max = MIN_VALUE;

        for (int number : numbers) {
            addNum = addEachNumber(number);
            multiNum = multiEachNumber(number);

            max = Math.max(max, addNum);
            max = Math.max(max, multiNum);
        }
        return max;
    }

    // 각 자릿수를 더하는 메서드
    private static int addEachNumber(int number) {
        int sum = 0;
        while (number != 0) {
            int result = number % 10;
            sum += result;
            number /= 10;
        }
        return sum;
    }

    // 각 자릿수를 곱하는 메서드
    private static int multiEachNumber(int number) {
        int multi = 1;
        while (number != 0) {
            int result = number % 10;
            multi *= result;
            number /= 10;
        }
        return multi;
    }
}