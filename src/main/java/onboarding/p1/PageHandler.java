package onboarding.p1;

import java.util.List;

public class PageHandler {
    public int getScore(List<Integer> pages) {
        return compareBigger(pages);
    }

    private int compareBigger(List<Integer> pages) {
        int max = 0;
        for (Integer page : pages) {
            int add = addAllDigits(page);
            int multi = multiplyAllDigits(page);
            if (max < add) {
                max = add;
            }
            if (max < multi) {
                max = multi;
            }
        }
        return max;
    }

    private int addAllDigits(Integer page) {
        int[] digits = getDigits(page);
        int result = 0;
        for (int digit : digits) result += digit;
        return result;
    }

    private int multiplyAllDigits(Integer page) {
        int[] digits = getDigits(page);
        int result = 1;
        for (int digit : digits) result *= digit;
        return result;
    }

    private int[] getDigits(Integer page) {
        char[] dit = page.toString().toCharArray();
        int[] digits = new int[dit.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] =  dit[i] - '0';
        }
        return digits;
    }
}
