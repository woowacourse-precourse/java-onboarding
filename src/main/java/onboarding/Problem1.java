package onboarding;

import java.util.List;

class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int TIE = 0;
    private static final int EXCEPTION_CASE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);

        if (!pobiPage.validPages || !crongPage.validPages) {
            return EXCEPTION_CASE;
        }

        answer = getAnswer(pobiPage.maxValue, crongPage.maxValue);

        return answer;
    }

    public static int getAnswer(int pobi, int crong) {
        if (pobi > crong) return POBI_WIN;
        if (pobi < crong) return CRONG_WIN;
        return TIE;
    }

    public static class Page {

        private final int leftPage;
        private final int rightPage;
        private final int maxValue;
        boolean validPages;

        public Page(List<Integer> pages) {
            this.leftPage = pages.get(0);
            this.rightPage = pages.get(1);

            this.validPages = isValidPages();

            int leftMaxValue = Math.max(calculateDigitSum(pages.get(0)), calculateDigitMultiple(pages.get(0)));
            int rightMaxValue = Math.max(calculateDigitSum(pages.get(1)), calculateDigitMultiple(pages.get(1)));
            this.maxValue = Math.max(leftMaxValue, rightMaxValue);
        }

        public int calculateDigitSum(int pageNumber) {
            int res = 0;
            while (pageNumber != 0) {
                res += pageNumber % 10;
                pageNumber /= 10;
            }
            return res;
        }

        public int calculateDigitMultiple(int pageNumber) {
            int res = 1;
            while (pageNumber != 0) {
                res *= pageNumber % 10;
                pageNumber /= 10;
            }
            return res;
        }

        public boolean isValidPages() {
            return isValidPageRange() && isOddPage() && isEvenPage() && checkPagesInterval();
        }

        public boolean isValidPageRange() {
            if (leftPage < 1 || leftPage > 400) return false;
            return rightPage >= 1 && rightPage <= 400;
        }

        public boolean isOddPage() {
            return leftPage % 2 == 1;
        }

        public boolean isEvenPage() {
            return rightPage % 2 == 0;
        }

        public boolean checkPagesInterval() {
            return rightPage - leftPage == 1;
        }

    }
}