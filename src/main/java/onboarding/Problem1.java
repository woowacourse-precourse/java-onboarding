package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(LEFT_PAGE) - pobi.get(RIGHT_PAGE) != -1 || crong.get(LEFT_PAGE) - crong.get(RIGHT_PAGE) != -1) {
            return -1;
        }

        int pobiHighValue = calc(pobi.get(LEFT_PAGE).toString(), pobi.get(RIGHT_PAGE).toString()),
                crongHighValue = calc(crong.get(LEFT_PAGE).toString(), crong.get(RIGHT_PAGE).toString());

        return 0;
    }

    private static int calc(String leftPage, String rightPage) {
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