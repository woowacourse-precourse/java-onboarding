package onboarding.support.problem1;

public final class Constants {

    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    private static final int ODD_MOD = 1;
    private static final int EVEN_MOD = 0;
    private static final int DIGIT_MOD = 10;
    private static final int PAGE_INTERVAL = 1;

    private Constants() {
    }

    public static int getLeftPageIndex() {
        return LEFT_PAGE_INDEX;
    }

    public static int getRightPageIndex() {
        return RIGHT_PAGE_INDEX;
    }

    public static int getMaxPage() {
        return MAX_PAGE;
    }

    public static int getMinPage() {
        return MIN_PAGE;
    }

    public static int getOddMod() {
        return ODD_MOD;
    }

    public static int getEvenMod() {
        return EVEN_MOD;
    }

    public static int getPageInterval() {
        return PAGE_INTERVAL;
    }

    public static int getDigitMod() {
        return DIGIT_MOD;
    }
}
