package onboarding;

import onboarding.problem1.PageChecker;

import java.util.List;

/**
 * Problem 01 function list
 * - Check availability of input
 * - Calculate max value of pages
 * - Get winner between person a and b
 */
class Problem1 {

    private final List<Integer> pagesA;
    private final List<Integer> pagesB;
    private final int SIZE;

    private final PageChecker checker;

    /**
     * Constructor with pages of person A and B
     * @param pagesA pages of person A
     * @param pagesB pages of person B
     * @param size max value of page number
     */
    public Problem1(List<Integer> pagesA, List<Integer> pagesB, int size) {
        this.pagesA = pagesA;
        this.pagesB = pagesB;
        this.SIZE = size;
        checker = new PageChecker(size);
    }

    /**
     * Get winner
     * @return 1 if person A wins, 2 if person B wins and 0 if draw
     * @throws WrongInputException throws exception if input values has an error
     */
    public int winner() throws WrongInputException {
        if (checker.isAvailableInput(pagesA) && checker.isAvailableInput(pagesB))
            return resultOfGame(valueOfPages(pagesA.get(0), pagesA.get(1)), valueOfPages(pagesB.get(0), pagesB.get(1)));
        else
            throw new WrongInputException("Wrong input");
    }

    /**
     * Exception to input value error
     */
    static class WrongInputException extends Exception {
        WrongInputException(String msg) {
            super(msg);
        }
    }

    /**
     * Max value that can be calculated with page numbers
     * @param left left page number
     * @param right right page number
     * @return max value
     */
    private int valueOfPages(int left, int right) {
        return Math.max(valueOfPage(left), valueOfPage(right));
    }

    /**
     * Max value that can be calculated with page number
     * @param page page number
     * @return max value
     */
    private int valueOfPage(int page) {
        return Math.max(plusEach(page), multiplyEach(page));
    }

    /**
     * Summation of each number in page number
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

    /**
     * Get result of game
     * @param aValue value of person A
     * @param bValue value of person B
     * @return 0 if draw or 1 if a wins and 2 if b wins
     */
    private int resultOfGame(int aValue, int bValue) {
        return aValue == bValue ? 0 : aValue > bValue ? 1 : 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Problem1 problem = new Problem1(pobi, crong, 400);
            return problem.winner();
        } catch (WrongInputException e) {
            return -1;
        }
    }
}