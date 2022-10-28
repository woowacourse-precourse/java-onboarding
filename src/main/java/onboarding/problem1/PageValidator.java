package onboarding.problem1;

import static onboarding.problem1.consts.PageIndexConst.LIST_LEFT_PAGE_INDEX;
import static onboarding.problem1.consts.PageIndexConst.LIST_RIGHT_PAGE_INDEX;
import static onboarding.problem1.consts.PageValidateConst.ADD_ODD_DIVISION_VALUE;
import static onboarding.problem1.consts.PageValidateConst.ADD_ODD_REMAINDER_VALUE;
import static onboarding.problem1.consts.PageValidateConst.BETWEEN_LEFT_AND_RIGHT_PAGE;
import static onboarding.problem1.consts.PageValidateConst.MAXIMUM_PAGE;
import static onboarding.problem1.consts.PageValidateConst.MINIMUM_PAGE;

import java.util.List;
import java.util.Objects;

public class PageValidator {

    private PageValidator() {
    }

    public static boolean validatePage(List<Integer> player) {
        Integer leftPageNumber = player.get(LIST_LEFT_PAGE_INDEX);
        Integer rightPageNumber = player.get(LIST_RIGHT_PAGE_INDEX);

        return validatePageRange(leftPageNumber) && validatePageRange(rightPageNumber)
            && validateRightPage(rightPageNumber) && validateLeftPage(leftPageNumber)
            && validatePageValue(player) && validateBetweenLeftAndRightPage(leftPageNumber,
            rightPageNumber);
    }

    private static boolean validatePageRange(Integer pageNumber) {
        return MINIMUM_PAGE <= pageNumber && pageNumber <= MAXIMUM_PAGE;
    }

    private static boolean validateBetweenLeftAndRightPage(Integer leftPageNumber,
        Integer rightPageNumber) {
        return rightPageNumber - leftPageNumber == BETWEEN_LEFT_AND_RIGHT_PAGE;
    }

    private static boolean validateRightPage(Integer rightPageNumber) {
        return rightPageNumber % ADD_ODD_DIVISION_VALUE == ADD_ODD_REMAINDER_VALUE;
    }

    private static boolean validateLeftPage(Integer leftPageNumber) {
        return leftPageNumber % ADD_ODD_DIVISION_VALUE != ADD_ODD_REMAINDER_VALUE;
    }

    private static boolean validatePageValue(List<Integer> player) {
        return !player.stream().anyMatch(Objects::isNull);
    }
}
