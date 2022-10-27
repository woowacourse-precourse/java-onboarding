package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    private static final char ZERO = '0';
    private static final int POBI = 1;
    private static final int CRONG = 2;
    private static final int TIE = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    public static List<List<Integer>> getEachDigitOfTwoPages(List<Integer> pages) {
        List<List<Integer>> digitsOfTwoPages = new ArrayList<>();

        for (Integer page : pages) {
            digitsOfTwoPages.add(getEachDigit(page));
        }

        return digitsOfTwoPages;
    }

    public static List<Integer> getEachDigit(Integer page) {
        List<Integer> digits = new ArrayList<>();
        String pageString = page.toString();

        for (int i = 0; i < pageString.length(); i++) {
            digits.add(pageString.charAt(i) - ZERO);
        }

        return digits;
    }

    public static Integer getScore(List<List<Integer>> digitsOfTwoPages) {
        List<Integer> num = new ArrayList<>();

        for (List<Integer> digits : digitsOfTwoPages) {
            num.add(plusEachDigit(digits));
            num.add(multiplyEachDigit(digits));
        }

        return getMax(num);
    }

    public static Integer plusEachDigit(List<Integer> digits) {
        Integer sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }

        return sum;
    }

    public static Integer multiplyEachDigit(List<Integer> digits) {
        Integer sum = 1;
        for (Integer digit : digits) {
            sum *= digit;
        }

        return sum;
    }

    public static Integer getMax(List<Integer> num) {
        return Collections.max(num);
    }

    public static Integer getWinner(Integer pobiScore, Integer crongScore) {
        if (pobiScore > crongScore) {
            return POBI;
        } else if (pobiScore < crongScore) {
            return CRONG;
        } else if (pobiScore == crongScore) {
            return TIE;
        }

        return EXCEPTION;
    }
}