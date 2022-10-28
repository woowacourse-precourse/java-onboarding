package onboarding;

import java.util.List;
import java.lang.Math;


class Problem1 {
    public static boolean isInRange(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (leftPage <= 1 || rightPage >= 400) {
            return false;
        }
        return true;
    }
    public static boolean isValid(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        if (pageList.get(1) - pageList.get(0) != 1 ) {
            return false;
        }

        if (!isInRange(pageList)) {
            return false;
        }

        return true;
    }
    public static int getMul(int page) {
        int result = 1;

        while(page > 0) {
            result *= page % 10;
            page /= 10;
        }

        return result;
    }
    public static int getSum(int page) {
        int result = 0;

        while(page > 0) {
            result += page % 10;
            page /= 10;
        }

        return result;
    }


    public static int getPageResult(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        int leftRes = Math.max(getSum(leftPage), getMul(leftPage));
        int rightRes = Math.max(getSum(rightPage), getMul(rightPage));

        return Math.max(leftRes, rightRes);
    }
    public static int getWinner(List<Integer> pobi, List<Integer> crong) {
        int draw = 0;
        int pobiWin = 1;
        int crongWin = 2;

        int pobiScore = getPageResult(pobi);
        int crongScore = getPageResult(crong);

        // 승자 처리
        if (pobiScore > crongScore) {
            return pobiWin;
        }
        else if (pobiScore < crongScore) {
            return crongWin;
        }
        else {
            return draw;
        }
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        answer = getWinner(pobi, crong);

        return answer;
    }
}