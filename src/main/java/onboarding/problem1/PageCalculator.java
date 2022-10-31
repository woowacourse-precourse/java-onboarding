package onboarding.problem1;

public class PageCalculator {

    public int valueOfPages(int left, int right) {
        return Math.max(valueOfPage(left), valueOfPage(right));
    }

    private int valueOfPage(int page) {
        return Math.max(plusDigits(page), multiplyDigits(page));
    }

    private int plusDigits(int page) {
        int sum = 0;
        while (page != 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private int multiplyDigits(int page) {
        int mul = 1;
        while (page != 0) {
            mul *= page % 10;
            page /= 10;
            if (mul == 0)
                break;
        }
        return mul;
    }
}
