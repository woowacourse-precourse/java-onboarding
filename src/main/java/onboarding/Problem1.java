package onboarding;

import java.util.List;

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
        if (rightPage - leftPage != 1) {
            return false;
        }

        return true;
    }

    private static boolean isOddLeft(int leftPage) {
        if (leftPage % 2 != 1) {
            return false;
        }

        return true;
    }

    private static boolean isEvenRight(int rightPage) {
        if (rightPage % 2 != 0) {
            return false;
        }

        return true;
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
