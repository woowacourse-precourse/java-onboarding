package onboarding.problem1;

/**
 * Calculate max value of pages
 */
public class PageCalculator {

    /**
     * Max value that can be calculated with page numbers
     *
     * @param left  left page number
     * @param right right page number
     * @return max value
     */
    public int valueOfPages(int left, int right) {
        return Math.max(valueOfPage(left), valueOfPage(right));
    }

    /**
     * Max value that can be calculated with page number
     *
     * @param page page number
     * @return max value
     */
    private int valueOfPage(int page) {
        return Math.max(plusEach(page), multiplyEach(page));
    }

    /**
     * Summation of each number in page number
     *
     * @param page page number
     * @return summation
     */
    private int plusEach(int page) {
        int sum = 0;
        while (page != 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    /**
     * Multiplied value of each number in page number
     *
     * @param page page number
     * @return multiplied value
     */
    private int multiplyEach(int page) {
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
