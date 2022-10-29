package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    private static final int EXCEPTION_RETURN = -1;
    private static final int DRAW_RETURN = 0;
    private static final int POBI_WIN_RETURN = 1;
    private static final int CRONG_WIN_RETURN = 2;


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isWrongData(pobi, crong)) {
            return EXCEPTION_RETURN;
        }

        int pobiHighNumber = pobiOrCrong(pobi),
                crongHighNumber = pobiOrCrong(crong);

        if (pobiHighNumber == crongHighNumber) {
            return DRAW_RETURN;
        } else if (pobiHighNumber > crongHighNumber) {
            return POBI_WIN_RETURN;
        } else if (pobiHighNumber < crongHighNumber) {
            return CRONG_WIN_RETURN;
        }

        return EXCEPTION_RETURN;
    }


    private static boolean isWrongData(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(LEFT_PAGE) - pobi.get(RIGHT_PAGE) != -1 || crong.get(LEFT_PAGE) - crong.get(RIGHT_PAGE) != -1) {
            return true;
        }
        return false;
    }


    private static int pobiOrCrong(List<Integer> pobiOrCrong) {
        String left = pobiOrCrong.get(LEFT_PAGE).toString();
        String right = pobiOrCrong.get(RIGHT_PAGE).toString();

        return getHighValueByPagePlusMultiple(left, right);
    }


    private static int getHighValueByPagePlusMultiple(String leftPage, String rightPage) {
        int leftPlus = 0, rightPlus = 0, leftMultiple = 1, rightMultiple = 1;

        for (int i = 0; i < leftPage.length(); i++) {
            // left page plus and multiplication
            leftPlus += leftPage.charAt(i) - '0';
            leftMultiple *= leftPage.charAt(i) - '0';

            // right page plus and multiplication
            rightPlus += rightPage.charAt(i) - '0';
            rightMultiple *= rightPage.charAt(i) - '0';
        }

        int plusValue = Math.max(leftPlus, rightPlus),
                multipleValue = Math.max(leftMultiple, rightMultiple);

        return Math.max(plusValue, multipleValue);
    }

}