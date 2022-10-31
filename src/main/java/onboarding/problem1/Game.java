package onboarding.problem1;

public class Game {

    private final static int MAX_PAGE = 400;
    private final static int MIN_PAGE = 1;

    private final static int POBI_WIN = 1;
    private final static int CRONG_WIN = 2;
    private final static int DRAW = 0;
    private final static int EXCEPTION = -1;

    public static int calculate(int leftPage, int rightPage) {
        if (!isSatisfiedCondition(leftPage, rightPage)) {
            return EXCEPTION;
        }
        Integer leftMax = getMax(leftPage);
        Integer rightMax = getMax(rightPage);
        return Math.max(leftMax, rightMax);
    }

    public static Integer getMax(Integer page) {
        String number = String.valueOf(page);
        Integer sum = 0, multiple = 1;
        for (int i=-0; i<number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
            multiple *= Character.getNumericValue(number.charAt(i));
        }
        return Math.max(sum,multiple);
    }

    public static boolean isSatisfiedCondition(int leftPage, int rightPage) {
        if (leftPage%2 != 1 || rightPage%2 != 0) {
            return false;
        }
        if (leftPage != rightPage-1) {
            return false;
        }
        if (leftPage <= MIN_PAGE || rightPage >= MAX_PAGE) {
            return false;
        }
        return true;
    }

    public static int compare(int pobiMax, int crongMax) {
        if (pobiMax == EXCEPTION || crongMax == EXCEPTION) {
            return EXCEPTION;
        }
        if (pobiMax > crongMax) {
            return POBI_WIN;
        }
        if (crongMax > pobiMax) {
            return CRONG_WIN;
        }
        return DRAW;
    }


}
