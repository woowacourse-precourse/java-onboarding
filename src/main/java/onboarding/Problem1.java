package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            int pobiScore = getScore(pobi);
            int crongScore = getScore(crong);

            if (pobiScore < crongScore)
                return 2;
            else if (pobiScore == crongScore)
                return 0;
            else
                return 1;
        } catch (PageNumException e) {
            return -1;
        }
    }

    // 펼친 왼쪽(홀수) / 오른쪽(짝수) 페이지를 이용해 점수를 반환
    private static int getScore(final List<Integer> pages) throws PageNumException {
        int oddPage = pages.get(0);
        int evenPage = pages.get(1);
        if (oddPage + 1 != evenPage || oddPage < 2 || evenPage > 399)
            throw new PageNumException();

        int oddScore = new DigitDecoder(oddPage).getMax();
        int evenScore = new DigitDecoder(evenPage).getMax();

        return Math.max(oddScore, evenScore);
    }

    // 페이지 숫자를 이용하여 자릿수 연산 결과를 반환
    static class DigitDecoder {
        int product = 1;
        int sum = 0;

        DigitDecoder(int num) {
            while (num > 1) {
                int digit = num % 10;
                product *= digit;
                sum += digit;
                num /= 10;
            }
        }

        int getMax() {
            return Math.max(this.product, this.sum);
        }
    }

    static class PageNumException extends Exception { }
}