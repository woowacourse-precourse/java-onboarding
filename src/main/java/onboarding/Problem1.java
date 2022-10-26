package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPage(pobi) || isInvalidPage(crong)) {
            return -1;
        }

        return 1;
    }

    private static boolean isInvalidPage(List<Integer> openPage) {
        if (openPage.size() != 2) {
            return true;
        }

        int leftPage = openPage.get(0);
        int rightPage = openPage.get(1);

        if (leftPage == 1 || rightPage == 400) {
            return true;
        }
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return true;
        }
        if (rightPage - leftPage != 1) {
            return true;
        }

        return false;
    }
}