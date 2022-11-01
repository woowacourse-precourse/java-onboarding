package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isWrongPage(pobi) || isWrongPage(crong)) {
            return -1;
        }

        int pobiSum = add(pobi);
        int pobiMulti = multiply(crong);
        int pobiMax = max(pobiSum, pobiMulti);

        int crongSum = add(crong);
        int crongMulti = multiply(crong);
        int crongMax = max(crongSum, crongMulti);

        if (pobiMax == crongMax) {
            return 0;
        } else {
            if (pobiMax > crongMax) {
                return 1;
            } else if (pobiMax < crongMax) {
                return 2;
            }
        }
        return -1;
    }

    private static int add(List<Integer> values) {
        int leftPageSum = getOnePageSum(values.get(0));
        int rightPageSum = getOnePageSum(values.get(1));

        return max(leftPageSum, rightPageSum);
    }

    private static int getOnePageSum(int pageNumber) {
        int onePageSum = 0;
        String[] stringArray = String.valueOf(pageNumber).split("");

        for (String number : stringArray) {
            onePageSum += Integer.parseInt(number);
        }

        return onePageSum;
    }

    private static int max(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    private static int multiply(List<Integer> values) {
        int leftPageMulti = getOnePageMulti(values.get(0));
        int rightPageMulti = getOnePageMulti(values.get(1));

        return max(leftPageMulti, rightPageMulti);
    }

    private static int getOnePageMulti(int pageNumber) {
        int onePageMulti = 1;
        String[] stringArray = String.valueOf(pageNumber).split("");

        for (String number : stringArray) {
            onePageMulti *= Integer.parseInt(number);
        }

        return onePageMulti;
    }

    private static boolean isWrongPage(List<Integer> values) {
        if (isFirstOrLast(values) || isNotNextPage(values)) {
            return true;
        }
        return false;
    }

    private static boolean isFirstOrLast(List<Integer> values) {
        for (int value : values) {
            if (value < 2 || value >= 400) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNotNextPage(List<Integer> values) {
        int firstPage = values.get(0);
        int secondPage = values.get(1);

        if (firstPage + 1 != secondPage) {
            return true;
        }

        return false;
    }

}