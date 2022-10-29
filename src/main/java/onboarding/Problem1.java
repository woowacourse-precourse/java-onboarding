package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!(isRightPageNum(pobi) && (isRightPageNum(crong)))) {
            return -1;
        }

        return answer;
    }

    private List<Integer> divideNumberByDigit (int pageNumber) {
        List<Integer> result = new ArrayList();
        for (int i = pageNumber; i > 0; i /= 10) {
            result.add(i % 10);
        }
        return result;
    }

    private static boolean isRightPageNum (List<Integer> pageNumbers) {
        int leftPage = pageNumbers.get(0);
        int rightPage = pageNumbers.get(1);

        if (leftPage < 1 || rightPage > 400) {
            return false;
        }

        if (rightPage - leftPage != 1) {
            return false;
        }

        if (leftPage % 2 == 0) {
            return false;
        }

        return true;
    }

    private int sumNumbers (List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    private int mulNumbers (List<Integer> numbers) {
        int result = 1;
        for (int i =0; i < numbers.size(); i++) {
            result *= numbers.get(i);
        }
        return result;
    }

    private int comPareTwoScore (int pobi, int crong) {
        if (pobi < crong) {
            return 1;
        }
        if (pobi > crong) {
            return 2;
        }
        return 0;
    }
}