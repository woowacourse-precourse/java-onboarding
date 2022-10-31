package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int DRAW = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);

        if (!isValidate(pobiPage) || !isValidate(crongPage)) {
            return EXCEPTION;
        }

        int pobiScore = getScore(pobiPage);
        int crongScore = getScore(crongPage);

        return answer;
    }

    private static boolean isValidate(Page page) {
        int leftPage = page.getLeftPage();
        int rightPage = page.getRightPage();

        if (!isInRange(leftPage, rightPage)) {
            return false;
        }

        if (!isContinuous(leftPage, rightPage)) {
            return false;
        }

        if (!isOddLeft(leftPage) || !isEvenRight(rightPage)) {
            return false;
        }
        return true;
    }

    private static boolean isInRange(int leftPage, int rightPage) {
        if (leftPage < 1 || rightPage > 400) {
            return false;
        }

        return true;
    }

    private static boolean isContinuous(int leftPage, int rightPage) {
        return rightPage - leftPage == 1;
    }

    private static boolean isOddLeft(int leftPage) {
        return leftPage % 2 == 1;
    }

    private static boolean isEvenRight(int rightPage) {
        return rightPage % 2 == 0;
    }

    private static int getScore(Page page) {
        int maxOfLeftScore = getMaxScore(page.getLeftPage());
        int maxOfRightScore = getMaxScore(page.getRightPage());

        if (maxOfLeftScore > maxOfRightScore) {
            return maxOfLeftScore;
        }

        return maxOfRightScore;
    }

    private static int getMaxScore(int page) {
        if (calculateBySum(page) > calculateByMultiply(page)) {
            return calculateBySum(page);
        }

        return calculateByMultiply(page);
    }

    private static int calculateBySum(int page) {
        int result = 0;
        while (page > 0) {
            result += page % 10;
            page /= 10;
        }
        return result;
    }

    private static int calculateByMultiply(int page) {
        int result = 1;
        while (page > 0) {
            result *= page % 10;
            page /= 10;
        }
        return result;
    }
}

class Page {
    private final int leftPage;
    private final int rightPage;

    public Page(List<Integer> score) {
        this.leftPage = score.get(0);
        this.rightPage = score.get(1);
    }

    public int getLeftPage() {
        return leftPage;
    }

    public int getRightPage() {
        return rightPage;
    }
}
