package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    static int ERROR_NUM = -1;
    static int FIRST_PAGE = 1;
    static int LAST_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            checkPages(pobi);
            checkPages(crong);
        } catch (Exception e) {
            //System.out.print(e.getMessage());
            answer = ERROR_NUM;
        }
        return answer;
    }

    public static int findMax(int num) {
        List<Integer> digits = new ArrayList<>();

        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }

        int sumDigits = digits.stream()
                .reduce(0, Integer::sum);
        int mulDigits = digits.stream()
                .reduce(1, (a, b) -> a * b);

        return Math.max(sumDigits, mulDigits);
    }

    public static void checkPages(List<Integer> pages) throws Exception {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage < FIRST_PAGE || rightPage > LAST_PAGE) {
            throw new Exception("페이지 범위를 초과했습니다.");
        }
        if (leftPage + 1 != rightPage) {
            throw new Exception("연속된 숫자를 입력해야 합니다.");
        }
        if (leftPage % 2 != 1) {
            throw new Exception("왼쪽 페이지는 홀수이어야 합니다.");
        }
    }
}