package onboarding;

import org.mockito.internal.matchers.CompareTo;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (!isPossiblePage(pobi, crong)) {
            return -1;
        }
        int pobiNumber = calculateMaxNumber(pobi);
        int crongNumber = calculateMaxNumber(crong);

        return answer;
    }

    private static int calculateMaxNumber(List<Integer> pageList) {
        int leftPageMaxNumber = sumOrMultiplyEachDigit(pageList.get(0));
        int rightPageMaxNumber = sumOrMultiplyEachDigit(pageList.get(1));
        return Math.max(leftPageMaxNumber, rightPageMaxNumber);
    }

    private static int sumOrMultiplyEachDigit(int page) {
        return Math.max(multiplyEachDigit(page), sumEachDigit(page));
    }

    private static int multiplyEachDigit(int page) {
        String number = String.valueOf(page);
        int total = 1; // 곱이기 때문에 0이 아닌 1로 설정
        for (int i=0; i<number.length(); i++) {
            total *= number.charAt(i) - '0';
        }
        return total;
    }

    private static int sumEachDigit(int page) {
        String number = String.valueOf(page);
        int total = 0;
        for (int i=0; i<number.length(); i++) {
            total += number.charAt(i) - '0';
        }
        return total;
    }

    private static boolean isPossiblePage(List<Integer> pobi, List<Integer> crong) {
        List<Integer> allPageList = new ArrayList<>();
        allPageList.addAll(pobi);
        allPageList.addAll(crong);
        if (!validatePageBoundary(allPageList)) {
            return false;
        }
        if (!validatePageConnectivity(pobi, crong)) {
            return false;
        }
        return true;
    }

    private static boolean validatePageConnectivity(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) != pobi.get(0)+1) {
            return false;
        }
        if (crong.get(1) != crong.get(0)+1) {
            return false;
        }
        return true;
    }

    private static boolean validatePageBoundary(List<Integer> allPageList) {
        for (int page : allPageList) {
            if (page < 1 || page > 400) {
                return false;
            }
        }
        return true;
    }
}