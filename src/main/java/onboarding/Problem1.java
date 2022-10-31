package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (isException(pobi) || isException(crong)) {
            return answer;
        }

        int pobiNumber = chooseLeftOrRight(pobi);
        int crongNumber = chooseLeftOrRight(crong);

        if (pobiNumber > crongNumber) {
            answer = 1;
        } else if (crongNumber > pobiNumber) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static boolean isException(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        int pageDifference = rightPage - leftPage;

        if (pageDifference != 1) {
            return true;
        } else if (rightPage > 400 || leftPage < 1) {
            return true;
        } else if (rightPage % 2 == 1) {
            return true;
        }

        return false;
    }

    private static int chooseLeftOrRight(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        List<Integer> leftPageNumberList = makeNumberList(leftPage);
        List<Integer> rightPageNumberList = makeNumberList(rightPage);

        int leftPageMaxNumber = chooseSumOrMultiply(leftPageNumberList);
        int rightPageMaxNumber = chooseSumOrMultiply(rightPageNumberList);

        return Math.max(leftPageMaxNumber, rightPageMaxNumber);
    }

    private static List<Integer> makeNumberList(int page) {
        List<Integer> numberList = new ArrayList<>();

        while (page  > 0) {
            int remainder = page % 10;
            page = page / 10;
            numberList.add(0, remainder);
        }

        return numberList;
    }

    private static int chooseSumOrMultiply(List<Integer> numberList) {
        int sum = 0;
        int multiply = 1;

        for (int i: numberList) {
            sum += i;
            multiply *= i;
        }

        return Math.max(sum, multiply);
    }
}