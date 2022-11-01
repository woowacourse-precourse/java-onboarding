package onboarding.problem1;

import java.util.List;

public class Validation {
    private static final int SEQUENCE_CHECK_NUMBER = 1;
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static boolean validate(List<Integer> pobi, List<Integer> crong) {
        return validateUser(pobi) && validateUser(crong);
    }

    private static boolean validateUser(List<Integer> user) {
        return validatePages(user.get(0), user.get(1));
    }

    private static boolean validatePages(int leftPage, int rightPage) {
        if (!validateLeftRightPage(leftPage, rightPage)) {
            return false;
        }
        if (!validatePageSequence(leftPage, rightPage)) {
            return false;
        }
        return validateInRange(leftPage) && validateInRange(rightPage);
    }

    private static boolean validateInRange(int page) {
        return (page > START_PAGE) && (page < END_PAGE);
    }

    private static boolean validateLeftRightPage(int leftPage, int rightPage) {
        return (leftPage % 2 != 0) && (rightPage % 2 == 0);
    }

    private static boolean validatePageSequence(int leftPage, int rightPage) {
        return rightPage - leftPage == SEQUENCE_CHECK_NUMBER;
    }
}
