package onboarding;

import java.util.List;
import java.lang.Math;


class Problem1 {
    public static int getMul(int page) {
        int result = 1;

        while(page > 0) {
            result *= page & 10;
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

        if (leftPage <= 1 || rightPage >= 400) {
            return -1;
        }
        if (rightPage - leftPage != 1) {
            return -1;
        }

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;



        return answer;
    }
}