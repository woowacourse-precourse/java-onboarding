package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        /**
         * 예외 처리
         */
        if (exception(pobi) | exception(crong)) {
            return -1;
        }

        /**
         * 점수 계산
         */
        Integer pobiScore = getScore(pobi);
        Integer crongScore = getScore(crong);

        /**
         * 반환
         */
        return getWinner(pobiScore, crongScore);
    }

    private static boolean exception(List<Integer> pages) {
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        if ((left == null) || (right == null)) {
            return true;
        }
        if (right - left != 1) {
            return true;
        }
        if (left >= 399 || left <= 1) {
            return true;
        }

        return false;
    }

    private static Integer getScore(List<Integer> pages){
        Integer left = pages.get(0);
        Integer right = pages.get(1);

        return Math.max(calScore(left), calScore(right));
    }

    private static Integer calScore(Integer page){
        Integer sum = 0;
        Integer multi = 1;

        while (page != 0) {
            Integer digit = page % 10;
            sum += digit;
            multi *= digit;
            page /= 10;
        }

        return Math.max(sum, multi);
    }

    private static Integer getWinner(Integer pScore, Integer cScore) {
        if (pScore > cScore) {
            return 1;
        } else if (pScore < cScore) {
            return 2;
        } else {
            return 0;
        }
    }
}