package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 양쪽 페이지를 확인하여 더 큰 페이지를 반환하는 함수
    private static int comparePages(List<Integer> pages) {
        int result = Integer.MIN_VALUE;
        verifyPages(pages);

        for(int page: pages) {
            List<Integer> pageNumbers = splitInt(page);
            int nowScore = maxScore(pageNumbers);
            if(result < nowScore)
                result = nowScore;
        }
        return result;
    }

    // 입력된 페이지가 정상인지 확인하는 함수
    private static void verifyPages(List<Integer> pages) {
        // 좌측 페이지가 홀수가 아닌 경우
        if(pages.get(0) % 2 == 0)
            throw new IllegalArgumentException("시작페이지 값이 잘못되었습니다. (홀수여야 합니다.)");
        // 입력된 페이지가 연속되지 않은 경우
        if(pages.get(1) - pages.get(0) != 1)
            throw new IllegalArgumentException("연속된 페이지가 아닙니다.");
    }

    // 숫자를 각 자릿수로 나눠서 배열로 반환하는 함수
    private static List<Integer> splitInt(Integer number) {
        List<Integer> result = new ArrayList<Integer>();

        // number의 각 자릿수를 result에 저장한다.
        while(number > 0) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }

    // 주어진 배열에 숫자들을 합하거나 곱하여 나오는 큰 수를 반환하는 함수
    private static int maxScore(List<Integer> numbers) {
        int resultSum = sumNumbers(numbers);
        int resultMulti = multiplyNumbers(numbers);

        return Math.max(resultSum, resultMulti);
    }

    // 주어진 배열에 수를 모두 합하는 함수
    private static int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for(int n : numbers)
            result += n;
        return result;
    }

    // 주어진 배열에 수를 모두 곱하는 함수
    private static int multiplyNumbers(List<Integer> numbers) {
        int result = 1;
        for(int n : numbers)
            result *= n;
        return result;
    }

    // 승패 결과 반환하는 함수
    private static int leftIsWin(int leftScore, int rightScore) {
        if(leftScore > rightScore)
            return 1;
        if(leftScore < rightScore)
            return 2;
        return 0;
    }
}