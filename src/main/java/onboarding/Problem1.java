package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validList(List<Integer> input) {
        int leftPage = input.get(0);
        int rightPage = input.get(1);

        if (leftPage<1 || 400<leftPage || rightPage<1 || 400<rightPage) return false;
        if (leftPage%2 != 1) return false;
        if (rightPage%2 != 0) return false;
        if (leftPage>=rightPage) return false;
        if (rightPage-leftPage != 1) return false;
        if (leftPage==1 || rightPage==2 || leftPage==399 || rightPage==400) return false;

        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (validList(pobi) == false || validList(crong) == false)
            return -1;

        int pobiScore = calScore(pobi);
        int crongScore = calScore(crong);

        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        if (pobiScore == crongScore) return 0;

        return -1;
    }
}