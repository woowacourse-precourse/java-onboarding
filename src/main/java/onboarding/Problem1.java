package onboarding;

import java.util.List;

class Problem1 {
    private static final int TIE = 0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Page pobiPage = Page.create(pobi.get(0), pobi.get(1));
        Page crongPage = Page.create(crong.get(0), crong.get(1));
        if (pobiPage.isInvalid() || crongPage.isInvalid())
            return EXCEPTION;
        return getWinner(pobiPage.getMaxResult(), crongPage.getMaxResult());
    }

    private static int getWinner(Integer pobiMaxNum, Integer crongMaxNum) {
        if (pobiMaxNum.equals(crongMaxNum))
            return TIE;
        if (pobiMaxNum > crongMaxNum)
            return POBI_WIN;
        return CRONG_WIN;
    }

    public static class Page {
        private final int leftPage;
        private final int rightPage;
        private static final int FIRST_PAGE_NUMBER = 1;
        private static final int LAST_PAGE_NUMBER = 400;
        private final Calculator calculator;

        private Page(int leftPage, int rightPage) {
            this.leftPage = leftPage;
            this.rightPage = rightPage;
            calculator = new Calculator();
        }

        public static Page create(int leftPage, int rightPage) {
            return new Page(leftPage, rightPage);
        }

        public boolean isInvalid() {
            return !isRightPageRange() || !isValidPageFormat();
        }

        private boolean isRightPageRange() {
            return this.leftPage > FIRST_PAGE_NUMBER || this.rightPage < LAST_PAGE_NUMBER;
        }

        private boolean isValidPageFormat() {
            return this.leftPage < this. rightPage && (rightPage - leftPage) == 1;
        }

        public int getMaxResult() {
            return getMaxFromLeftAndRightPage();
        }

        private int getMaxFromLeftAndRightPage() {
            int leftResult = getMaxFromOnePage(leftPage);
            int rightResult = getMaxFromOnePage(rightPage);
            return Math.max(leftResult, rightResult);
        }

        private int getMaxFromOnePage(int page) {
            return Math.max(calculator.getAddNum(page), calculator.getMulNum(page));
        }

        private static class Calculator {
            private int addNum = 0;
            private int mulNum = 1;

            Calculator() {}

            public int getAddNum(int page) {
                add(page);
                return addNum;
            }

            public int getMulNum(int page) {
                multiple(page);
                return mulNum;
            }

            private void add(int page) {
                while ( page > 0 ) {
                    int i = page % 10;
                    addNum += i;
                    page /= 10;
                }
            }

            private void multiple(int page) {
                while ( page > 0 ) {
                    int i = page % 10;
                    mulNum *= i;
                    page /= 10;
                }
            }
        }
    }
}