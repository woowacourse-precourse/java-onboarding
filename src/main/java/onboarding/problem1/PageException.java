package onboarding.problem1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PageException {

    public static boolean checkException(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);

        return isNotRange(pageList) ||
                isNotOddNum(leftPage) ||
                isNotEvenNum(rightPage) ||
                isNotContinuousPage(leftPage, rightPage) ||
                isNotLength(pageList);
    }

    private static boolean isNotRange(List<Integer> pageList) {
        return pageList.contains(1) || pageList.contains(400);
    }

    private static boolean isNotOddNum(int leftPage) {
        return leftPage%2 == 0;
    }

    private static boolean isNotEvenNum(int rightPage) {
        return rightPage%2 != 0;
    }

    private static boolean isNotContinuousPage(int leftPage, int rightPage) {
        return leftPage + 1 != rightPage;
    }

    private static boolean isNotLength(List<Integer> pageList) {
        return pageList.size() != 2;
    }
}