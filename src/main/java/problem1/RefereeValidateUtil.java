package problem1;

import java.util.List;

public class RefereeValidateUtil {

    private static final int CONTINOUS_CRITERION = 1;
    private static final int START_PAGE_NUMBER_LEFT = 1;
    private static final int START_PAGE_NUMBER_RIGHT = 2;
    private static final int END_PAGE_NUMBER_LEFT = 399;
    private static final int END_PAGE_NUMBER_RIGHT = 400;
    private static final String INPUT_EXCEPTION_MESSAGE = "올바르지 않은 입력 값 입니다.";
    public static final int ODD_EVEN_DIVIDION = 2;
    public static final int ODD_EVEN_CRITERION = 0;

    public static void validate(List<Integer> pobi, List<Integer> crong) {
        validate(pobi);
        validate(crong);
    }

    private static void validate(List<Integer> player) {
        int leftPageNumber = player.get(Player.LEFT_PAGE_INDEX);
        int rightPageNumber = player.get(Player.RIGHT_PAGE_INDEX);

        validateRightPage(leftPageNumber, rightPageNumber);
        validateContinuousPage(leftPageNumber, rightPageNumber);
        validateStartPage(leftPageNumber, rightPageNumber);
        validateEndPage(leftPageNumber, rightPageNumber);
    }

    private static void validateEndPage(int leftPageNumber, int rightPageNumber) {
        if (isEndPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateStartPage(int leftPageNumber, int rightPageNumber) {
        if (isStartPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateContinuousPage(int leftPageNumber, int rightPageNumber) {
        if (!isContinuousPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateRightPage(int leftPageNumber, int rightPageNumber) {
        if (!isRightPage(leftPageNumber, rightPageNumber)) {
            throw new IllegalArgumentException(INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isEndPage(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber == END_PAGE_NUMBER_LEFT
                && rightPageNumber == END_PAGE_NUMBER_RIGHT;
    }

    private static boolean isStartPage(int leftPageNumber, int rightPageNumber) {
        return leftPageNumber == START_PAGE_NUMBER_LEFT
                && rightPageNumber == START_PAGE_NUMBER_RIGHT;
    }

    private static boolean isContinuousPage(int leftPageNumber, int rightPageNumber) {
        return rightPageNumber - leftPageNumber == CONTINOUS_CRITERION;
    }

    private static boolean isRightPage(int left, int right) {
        return left % ODD_EVEN_DIVIDION != ODD_EVEN_CRITERION && right % ODD_EVEN_DIVIDION == ODD_EVEN_CRITERION;
    }
}
