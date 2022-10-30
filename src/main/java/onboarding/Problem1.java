package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        List<Integer> pobiNumbers = getAllNumbers(pobiLeftPage, pobiRightPage);
        List<Integer> crongNumbers = getAllNumbers(crongLeftPage, crongRightPage);

        return answer;
    }

    private static char[] getEachPageNumbers(int page) {
        String s = Integer.toString(page);
        return s.toCharArray();
    }

    private static int getPageSum(char[] pageNumbers) {
        int result = 0;
        for (char c : pageNumbers) {
            result += c - '0';
        }
        return result;
    }

    private static int getPageMultiply(char[] pageNumbers) {
        int result = 0;
        for (char c : pageNumbers) {
            result *= c - '0';
        }
        return result;
    }

    private static List<Integer> getAllNumbers(int leftPage, int rightPage) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(getPageSum(getEachPageNumbers(leftPage)));
        numbers.add(getPageSum(getEachPageNumbers(rightPage)));

        numbers.add(getPageMultiply(getEachPageNumbers(leftPage)));
        numbers.add(getPageMultiply(getEachPageNumbers(rightPage)));

        return numbers;
    }

}
