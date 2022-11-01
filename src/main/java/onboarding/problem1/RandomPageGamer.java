package onboarding.problem1;

import java.util.List;

public class RandomPageGamer {

    private final List<Integer> playerOnePages, playerTwoPages;

    private final InputValidator validator;
    private final PageCalculator calculator;

    public RandomPageGamer(List<Integer> playerOnePages, List<Integer> playerTwoPages, int size) {
        this.playerOnePages = playerOnePages;
        this.playerTwoPages = playerTwoPages;
        validator = new InputValidator(size);
        calculator = new PageCalculator();
    }

    public int play() throws WrongInputException {
        if (validator.validate(playerOnePages) && validator.validate(playerTwoPages))
            return resultOfGame(calculator.valueOfPages(playerOnePages.get(0), playerOnePages.get(1)),
                    calculator.valueOfPages(playerTwoPages.get(0), playerTwoPages.get(1)));
        else
            throw new WrongInputException("Wrong input");
    }

    private int resultOfGame(int playerOneValue, int playerTwoValue) {
        return playerOneValue == playerTwoValue ? 0 : playerOneValue > playerTwoValue ? 1 : 2;
    }
}
