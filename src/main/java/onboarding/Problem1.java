package onboarding;

import java.util.List;

class Problem1 {

    static boolean isVaild(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (rightPage - leftPage != -1)
            return false;

        if (leftPage >= 3 && leftPage <= 397) {
            return leftPage % 2 == 1;
        } else {
            return false;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isVaild(pobi) || !isVaild(crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}