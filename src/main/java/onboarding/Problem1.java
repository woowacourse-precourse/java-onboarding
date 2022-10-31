package onboarding;

import onboarding.problem1.Page;

import java.util.List;

class Problem1 {
    static final int MAX_PAGE = 397;
    static final int MIN_PAGE = 3;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!validatePageNumber(pobi) || !validatePageNumber(crong)) {
            return -1;
        }

        int pobiScore = Page.getBiggerPage(pobi);
        int crongScore = Page.getBiggerPage(crong);

        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    public static boolean validatePageNumber(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        if (pages.size() != 2) {
            return false;
        }
        if (leftPage < MIN_PAGE || leftPage > MAX_PAGE) {
            return false;
        }
        if (leftPage % 2 == 0) {
            return false;
        }
        if (rightPage != leftPage + 1) {
            return false;
        }
        return true;
    }
}