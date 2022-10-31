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
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }

    }

    private static boolean exception(List<Integer> pages) {
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        if ((left == null) || (right == null)) {
            return true;
        }

        if (right - left != 1) {
            System.out.println("wrong number");
            return true;
        }
        if (left >= 399 || left <= 1) {
            System.out.println("out of range left");
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
        List<Integer> digits = new ArrayList<>();

        while (page != 0) {
            digits.add(page % 10);
            page /= 10;
        }

        Integer sum = 0;
        Integer multi = 1;

        for (int i = 0; i < digits.size(); i++) {
            Integer num = digits.get(i);
            sum += num;
            multi *= num;
        }

        return Math.max(sum, multi);
    }

}