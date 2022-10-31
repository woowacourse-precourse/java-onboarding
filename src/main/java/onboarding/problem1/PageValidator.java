package onboarding.problem1;

import java.util.List;

public class PageValidator {

    private static final Integer PAGE_SIZE = 2;

    public static boolean isValidatePage(List<Integer> pobi, List<Integer> crong) {

        if (!validatePageSize(pobi, crong)) {
            return false;
        }
        if (!validatePageNumber(pobi, crong)) {
            return false;
        }
        if (!validatePageOddEven(pobi, crong)) {
            return false;
        }
        if (!validateLeftPageAndRightPageIsContinuousPageNumber(pobi, crong)) {
            return false;
        }
        return true;
    }

    private static boolean validatePageSize(List<Integer> pobi, List<Integer> crong) {
        return pobi.size() == PAGE_SIZE && crong.size() == PAGE_SIZE;
    }

    private static boolean validatePageNumber(List<Integer> pobi, List<Integer> crong) {
        if (pageNumberIsNotBetweenOneAndFourHundred(pobi)) {
            return false;
        }
        return !pageNumberIsNotBetweenOneAndFourHundred(crong);
    }

    private static boolean validatePageOddEven(List<Integer> pobi, List<Integer> crong) {
        if (leftPageNumberIsNotOddAndRightPageNumberIsNotEven(pobi)) {
            return false;
        }
        return !leftPageNumberIsNotOddAndRightPageNumberIsNotEven(crong);
    }

    private static boolean validateLeftPageAndRightPageIsContinuousPageNumber(List<Integer> pobi, List<Integer> crong) {
        if (leftPageNumberPlusOneIsNotEqualToRightPageNumber(pobi)) {
            return false;
        }
        return !leftPageNumberPlusOneIsNotEqualToRightPageNumber(crong);
    }

    private static boolean leftPageNumberPlusOneIsNotEqualToRightPageNumber(List<Integer> list) {
        return list.get(0) + 1 != list.get(1);
    }

    private static boolean leftPageNumberIsNotOddAndRightPageNumberIsNotEven(List<Integer> list) {
        final Integer leftNumber = list.get(0);
        final Integer rightNumber = list.get(1);

        if (leftNumber % 2 == 0) {
            return true;
        }
        return rightNumber % 2 == 1;
    }

    private static boolean pageNumberIsNotBetweenOneAndFourHundred(List<Integer> list) {
        return list.stream()
                .anyMatch(pageNumber -> pageNumber <= 0 || pageNumber > 400);
    }
}
