package onboarding.p1;

import java.util.List;

public class PageHandler {
    // 컨텍스트에 반환
    public int getScore(List<Integer> pages) {
        return compareBigger(pages);
    }

    // 각 자릿수를 더한 것과 곱한 것 중 더 큰 값을 반환
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

    // 각 자릿수를 더함
    private int addAllDigits(Integer page) {
        int[] digits = getDigits(page);
        int result = 0;
        for (int digit : digits) result += digit;
        return result;
    }

    // 각 자릿수를 곱함
    private int multiplyAllDigits(Integer page) {
        int[] digits = getDigits(page);
        int result = 1;
        for (int digit : digits) result *= digit;
        return result;
    }

    // 자릿수를 int 형 배열로 리턴
    private int[] getDigits(Integer page) {
        char[] dit = page.toString().toCharArray();
        int[] digits = new int[dit.length];
        for (int i = 0; i < digits.length; i++) {
            digits[i] =  dit[i] - '0';
        }
        return digits;
    }
}
