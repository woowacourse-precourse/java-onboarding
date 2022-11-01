package problem1;

import java.util.Arrays;
import java.util.stream.Stream;

public class Page {
    private int leftPage;
    private int rightPage;

    public Page(int leftPage, int rightPage) {
        this.leftPage = leftPage;
        this.rightPage = rightPage;
    }

    public boolean checkPage() {
        return isRightRange(leftPage) && isRightRange(rightPage)
                && !isEven(leftPage) && isEven(rightPage)
                && isNext();
    }

    private boolean isNext() {
        return leftPage + 1 == rightPage;
    }

    private boolean isEven(int page) {
        return page % 2 == 0;
    }

    private boolean isRightRange(int page) {
        return page >= 3 && page <= 398;
    }

    public int getMaxValue() {
        int[] leftDigits = getDigits(leftPage);
        int[] rightDigits = getDigits(rightPage);

        return Math.max(getMaxSum(leftDigits, rightDigits)
                , getMaxProduct(leftDigits, rightDigits));
    }

    private int getMaxProduct(int[] leftDigits, int[] rightDigits) {
        return Math.max(getProduct(leftDigits), getProduct(rightDigits));
    }

    private int getMaxSum(int[] leftDigits, int[] rightDigits) {
        return Math.max(getSum(leftDigits), getSum(rightDigits));
    }

    private int getProduct(int[] digits) {
        return Arrays
                .stream(digits)
                .reduce(1, (x, y) -> x * y);
    }

    private int getSum(int[] digits) {
        return Arrays
                .stream(digits)
                .reduce(0, Integer::sum);
    }

    private int[] getDigits(int page) {
        return Stream.of(getSplit(page))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private String[] getSplit(int page) {
        return toString(page).split("");
    }

    private String toString(int page) {
        return String.valueOf(page);
    }

}
