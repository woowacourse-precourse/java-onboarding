package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class Page {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    private int leftPage;
    private int rightPage;

    Page(List<Integer> user) {
        this.leftPage = user.get(LEFT_PAGE);
        this.rightPage = user.get(RIGHT_PAGE);
    }
    public int getLeftPage() {
        return leftPage;
    }
    public int getRightPage() {
        return rightPage;
    }

    public static List<Integer> getPossibleValFromPage(Page page) {
        List<Integer> possibleValues = Arrays.asList(
                Calculator.getDigitSum(page.getLeftPage()), Calculator.getDigitSum(page.getRightPage()),
                Calculator.getDigitMult(page.getLeftPage()), Calculator.getDigitMult(page.getRightPage()));
        return possibleValues;
    }
}
