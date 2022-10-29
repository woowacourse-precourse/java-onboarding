package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private List<Integer> divideNumberByDigit (int pageNumber) {
        List<Integer> result = new ArrayList();
        for (int i = pageNumber; i > 0; i /= 10) {
            result.add(i % 10);
        }
        return result;
    }

    private boolean isRightPageNum (List<Integer> pageNumbers) {
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
}