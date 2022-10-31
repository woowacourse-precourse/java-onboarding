package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isExceptionExists(pobi, crong)) {
            return -1;
        }

        int pobiScore = findBiggerCalculatedPage(pobi);
        int crongScore = findBiggerCalculatedPage(crong);

        if (crongScore == pobiScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        return 2;
    }

    public static boolean isExceptionExists(List<Integer> pobi, List<Integer> crong) {
        if ((isPageNotEmpty(pobi) && isPageNotEmpty(crong)) == false) {
            return true;
        }
        if ((isTwoPages(pobi) && isTwoPages(crong)) == false) {
            return true;
        }

        if ((isValidPageNumber(pobi) && isValidPageNumber(crong)) == false) {
            return true;
        }
        if ((isValidPlace(pobi) && isValidPlace(crong)) == false) {
            return true;
        }

        if ((isGapOfPagesOne(pobi) && isGapOfPagesOne(crong)) == false) {
            return true;
        }
        return false;
    }

    public static boolean isTwoPages(List<Integer> page) {
        if (page.size() != 2) {
            return false;
        }
        return true;
    }

    public static boolean isPageNotEmpty(List<Integer> page) {
        if (page.get(0) == null || page.get(1) == null) {
            return false;
        }
        return true;
    }

    public static boolean isValidPageNumber(List<Integer> page) {
        if ((page.get(0) < 3 || page.get(0) > 398) || (page.get(1) < 3 || page.get(1) > 398)) {
            return false;
        }
        return true;
    }

    public static boolean isGapOfPagesOne(List<Integer> page) {
        if (page.get(1) - page.get(0) != 1) {
            return false;
        }
        return true;
    }

    public static boolean isValidPlace(List<Integer> page) {
        if (page.get(0) % 2 != 1 || page.get(1) % 2 != 0) {
            return false;
        }
        return true;
    }

    public static int findBiggerCalculatedPage(List<Integer> page) {
        int leftBig = compareAddMultiple(Integer.toString(page.get(0)));
        int rightBig = compareAddMultiple(Integer.toString(page.get(1)));

        if (leftBig > rightBig) {
            return leftBig;
        }
        return rightBig;
    }

    private static int compareAddMultiple(String number) {
        int addResult = 0;
        int multipleResult = 0;

        addResult = addNumbersOfString(number);
        multipleResult = multipleNumbersOfString(number);

        if (addResult < multipleResult) {
            return multipleResult;
        }
        return addResult;
    }

    private static int addNumbersOfString(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
        }
        return sum;
    }

    private static int multipleNumbersOfString(String number) {
        int sum = 1;
        for (int i = 0; i < number.length(); i++) {
            sum *= number.charAt(i) - '0';
        }
        return sum;
    }

}