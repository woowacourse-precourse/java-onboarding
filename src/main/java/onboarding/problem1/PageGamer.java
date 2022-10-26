package onboarding.problem1;

import java.util.List;

/**
 * Gamer class which plays the game
 */
public class PageGamer {

    private final List<Integer> pagesA;
    private final List<Integer> pagesB;

    private final PageChecker checker;
    private final PageCalculator calculator;

    /**
     * Constructor with pages of person A and B
     *
     * @param pagesA pages of person A
     * @param pagesB pages of person B
     * @param size   max value of page number
     */
    public PageGamer(List<Integer> pagesA, List<Integer> pagesB, int size) {
        this.pagesA = pagesA;
        this.pagesB = pagesB;
        checker = new PageChecker(size);
        calculator = new PageCalculator();
    }

    /**
     * Get winner
     *
     * @return 1 if person A wins, 2 if person B wins and 0 if draw
     * @throws WrongInputException throws exception if input values has an error
     */
    public int play() throws WrongInputException {
        if (checker.isAvailableInput(pagesA) && checker.isAvailableInput(pagesB))
            return resultOfGame(calculator.valueOfPages(pagesA.get(0), pagesA.get(1)), calculator.valueOfPages(pagesB.get(0), pagesB.get(1)));
        else
            throw new WrongInputException("Wrong input");
    }

    /**
     * Get result of game
     *
     * @param aValue value of person A
     * @param bValue value of person B
     * @return 0 if draw or 1 if a wins and 2 if b wins
     */
    private int resultOfGame(int aValue, int bValue) {
        return aValue == bValue ? 0 : aValue > bValue ? 1 : 2;
    }
}
