package onboarding;

import java.util.List;


class Problem1 {

    private static final int EXCEPTION = -1;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;

    private static final int MIN = 1;
    private static final int MAX = 400;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    public static int getSumPage(int page) {
        int sumResult = 0;
        String pages = Integer.toString(page);
        for (int i = 0; i < pages.length(); i++) {
            sumResult += (pages.charAt(i) - '0');
        }
        return sumResult;
    }


}