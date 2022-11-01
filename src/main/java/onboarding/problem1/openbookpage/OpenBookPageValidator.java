package onboarding.problem1.openbookpage;

import onboarding.problem1.exception.OpenBookPageValid;
import onboarding.problem1.exception.OpenBookPageValidException;

import java.util.Arrays;

public class OpenBookPageValidator {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public void validate(OpenBookPage ...openBookPages) {
        Arrays.stream(openBookPages)
                .forEach(this::validateIndividual);
    }

    private void validateIndividual(OpenBookPage openBookPage) {
        validateBetweenStartAndEnd(openBookPage);
        validateOddAndEven(openBookPage);
        validateBeside(openBookPage);
    }

    private void validateBetweenStartAndEnd(OpenBookPage openBookPage) {
        if(openBookPage.getLeftPage() <= START_PAGE ||
                openBookPage.getRightPage() >= END_PAGE) {
            throw new OpenBookPageValidException(OpenBookPageValid.PAGE_OVER);
        }
    }
    private void validateOddAndEven(OpenBookPage openBookPage) {
        checkLeftPage(openBookPage.getLeftPage());
        checkRightPage(openBookPage.getRightPage());
    }

    private void checkRightPage(int rightPage) {
        if(!isEven(rightPage)) {
            throw new OpenBookPageValidException(OpenBookPageValid.BAD_PAGE_EVEN_SETTING);
        }
    }

    private void checkLeftPage(int leftPage) {
        if (isEven(leftPage)) {
            throw new OpenBookPageValidException(OpenBookPageValid.BAD_PAGE_ODD_SETTING);
        }
    }

    private boolean isEven(int number) {
        return number%2 == 0;
    }
    private void validateBeside(OpenBookPage openBookPage) {
        if(openBookPage.getLeftPage() !=
                openBookPage.getRightPage() -1) {
            throw new OpenBookPageValidException(OpenBookPageValid.PAGE_NOT_SIDE_BY_SIDE);
        }
    }

}
