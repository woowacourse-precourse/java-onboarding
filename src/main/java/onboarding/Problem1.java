package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!checkRange(pobi) || !checkRange(crong)) {
            return -1;
        }

        if (!isLegalPage(pobi) || !isLegalPage(crong)) {
            return -1;
        }

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        return (pobiScore > crongScore) ? 1 : (pobiScore < crongScore) ? 2 : 0;
    }

    /**
     * check if page is smaller than 2 or bigger than 399
     * @param pages
     * @return
     */
    static boolean checkRange(List<Integer> pages) {
        for (Integer page : pages) {
            if ((page <= 1) || (page >= 400)) {
                return false;
            }
        }
        return true;
    }

    /**
     * check pages if left page bigger than right one,
     * or two pages's diff is bigger than 1
     * @param pages
     * @return
     */
    static boolean isLegalPage(List<Integer> pages) {
        if (pages.get(1) < pages.get(0)) {
            return false;
        }
        if ((pages.get(1) - pages.get(0)) != 1) {
            return false;
        }
        return true;
    }

    /**
     * calculate left and right page's score of summation, multiplication
     * and return the biggest one
     * @param pages
     * @return
     */
    static int calculateScore(List<Integer> pages) {
        int leftScore = Math.max(sumScore(pages.get(0)), mulScore(pages.get(0)));
        int rightScore = Math.max(sumScore(pages.get(1)), mulScore(pages.get(1)));

        return Math.max(leftScore, rightScore);
    }

    /**
     * calculate score of page by summation
     * @param page
     * @return
     */
    static int sumScore(Integer page) {
        int sum = 0;
        while (page != 0) {
            sum += page % 10;
            page /= 10;
        }

        return sum;
    }

    /**
     * calculate score of page by multiplication
     * @param page
     * @return
     */
    static int mulScore(Integer page) {
        int mul = 1;
        while (page != 0) {
            mul *= page % 10;
            page /= 10;
        }

        return mul;
    }
}