package onboarding.problem1;

import java.util.List;

public class RandomPageGamer {

    private final List<Integer> pagesA;
    private final List<Integer> pagesB;

    private final InputValidator validator;
    private final PageCalculator calculator;

    public RandomPageGamer(List<Integer> pagesA, List<Integer> pagesB, int size) {
        this.pagesA = pagesA;
        this.pagesB = pagesB;
        validator = new InputValidator(size);
        calculator = new PageCalculator();
    }

    public int play() throws WrongInputException {
        if (validator.validate(pagesA) && validator.validate(pagesB))
            return resultOfGame(calculator.valueOfPages(pagesA.get(0), pagesA.get(1)),
                    calculator.valueOfPages(pagesB.get(0), pagesB.get(1)));
        else
            throw new WrongInputException("Wrong input");
    }

    private int resultOfGame(int aValue, int bValue) {
        return aValue == bValue ? 0 : aValue > bValue ? 1 : 2;
    }
}
