package onboarding;

import java.util.List;
import java.lang.Math;


class Problem1 {

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