package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isException(pobi.get(0), pobi.get(1)) || isException(crong.get(0), crong.get(1))) {
            return -1;
        }

        int pobiNumber = calculateMaxNumber(pobi.get(0), pobi.get(1));
        int crongNumber = calculateMaxNumber(crong.get(0), crong.get(1));

        if (pobiNumber > crongNumber) {
            answer = 1;
        } else if (crongNumber > pobiNumber) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }

    private static boolean isException(int leftPage, int rightPage) {
        int pageDifference = rightPage - leftPage;
        if (pageDifference == 1) {
            return false;
        } else if (rightPage > 400 || leftPage < 1) {
            return false;
        }
        return true;
    }

    private static int calculateMaxNumber(int leftPage, int rightPage) {
        List<Integer> leftPageNumberList = makeNumberList(leftPage);
        List<Integer> rightPageNumberList = makeNumberList(rightPage);

        int leftPageMaxNumber = chooseSumOrMultiply(leftPageNumberList);
        int rightPageMaxNumber = chooseSumOrMultiply(rightPageNumberList);

        if (leftPageMaxNumber > rightPageMaxNumber) {
            return leftPageMaxNumber;
        }
        return rightPageMaxNumber;
    }

    private static List<Integer> makeNumberList(int page) {
        List<Integer> numberList = new ArrayList<>();
        while (page / 10 > 0) {
            int remainder = page % 10;
            page = page / 10;
            numberList.add(0, remainder);
        }
        numberList.add(0, page);
        return numberList;
    }

    private static int chooseSumOrMultiply(List<Integer> numberList) {
        int sum = 0;
        int multiply = 1;

        for (int i: numberList) {
            sum += i;
            multiply *= i;
        }

        if (sum > multiply) {
            return sum;
        }
        return multiply;
    }
}