package onboarding;

import java.util.List;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean checkValidator(List<Integer> userA, List<Integer> userB) {
        return validator(userA) && validator(userB);
    }

    private static boolean validator(List<Integer> inputPage) {
        Integer leftPage = null;
        Integer rightPage = null;

        // 길이가 2인지 확인한다.
        if (inputPage.size() != 2) {
            return false;
        }

        // 길이가 2이고, 정수라면 변수에 값을 설정해준다.
        try {
            leftPage = inputPage.get(0);
            rightPage = inputPage.get(1);
        } catch (Exception e) {
            return false;
        }


        // 왼쪽 페이지는 홀수이다.
        if (leftPage % 2 != 1) {
            return false;
        }

        // 오른쪽 페이지는 짝수이다.
        if (rightPage % 2 != 0) {
            return false;
        }

        // 연속된 숫자여야한다.
        if (rightPage - leftPage != 1) {
            return false;
        }

        // 시작 면이나 마지막 면이 나오지 않도록 해야 한다.
        // 왼쪽 페이지는 1페이지 ~ 400페이지가 나와야 한다.
        if (!(1 <= leftPage && leftPage <= 400)) {
            return false;
        }

        // 오른쪽 페이지는 1페이지 ~ 400페이지가 나와야 한다.
        if (!(1 <= rightPage && rightPage <= 400)) {
            return false;
        }

        return true;
    };
}