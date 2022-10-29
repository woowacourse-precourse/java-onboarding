package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    private static final int POBY_WIN_CODE = 1;
    private static final int CRONG_WIN_CODE = 2;
    private static final int DRAW_CODE = 0;
    private static final int EXCEPTION_CASE_CODE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidPages(pobi) || !isValidPages(crong))
            return EXCEPTION_CASE_CODE;

        List<Integer> pobiScores = getScores(pobi);
        List<Integer> crongScores = getScores(crong);

        return answer;
    }

    public static boolean isValidPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        if (leftPage % 2 != 1 || rightPage % 2 != 0)
            return false;

        if (leftPage <= 1 || rightPage >= 400)
            return false;

        if (leftPage >= rightPage)
            return false;

        if (rightPage - leftPage != 1)
            return false;

        return true;
    }

    public static int getPageElementsSumScore(Integer page) {
        char[] pageElements = Integer.toString(page).toCharArray();

        int sum = 0;
        for (char value : pageElements)
            sum += (value -'0');

        return sum;
    }

    public static Integer getPageElementsMultiplyScore(Integer page) {
        char[] pageElements = Integer.toString(page).toCharArray();

        int multiply = 1;
        for (char value : pageElements)
            multiply *= (value - '0');

        return multiply;
    }

    public static List<Integer> getScores(List<Integer> pages) {

        List<Integer> scores = new ArrayList<>();
        for (Integer page : pages) {
            scores.add(getPageElementsSumScore(page));
            scores.add(getPageElementsMultiplyScore(page));
        }
        return scores;
    }

}