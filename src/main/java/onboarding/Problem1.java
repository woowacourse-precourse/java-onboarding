package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return new Solver1(pobi, crong).solve();
    }
}

class Solver1 {

    private static final int WIN_POBI = 1;
    private static final int WIN_CRONG = 2;
    private static final int DRAW = 0;
    private static final int ERROR = -1;

    private final List<Integer> pobi;
    private final List<Integer> crong;

    public Solver1(final List<Integer> pobi, final List<Integer> crong) {
        this.pobi = pobi;
        this.crong = crong;
    }

    public int solve() {
        try {
            this.assertPagesAreSubsequent();

            final int pobiMax = this.pobiMax();
            final int crongMax = this.crongMax();

            return this.winner(pobiMax, crongMax);
        } catch (Exception e) {
            return ERROR;
        }
    }

    /**
     * 두 페이지가 연속되어있는지 확인
     */
    private void assertPagesAreSubsequent() {
        if (this.firstPobiPage() != this.secondPobiPage() - 1) {
            throw new IllegalArgumentException("Invalid input from Pobi");
        }
        if (this.firstCrongPage() != this.secondCrongPage() - 1) {
            throw new IllegalArgumentException("Invalid input from Crong");
        }
    }

    private int pobiMax() {
        return Math.max(this.pobiSumMax(), this.pobiMulMax());
    }

    private int crongMax() {
        return Math.max(this.crongSumMax(), this.crongMulMax());
    }

    private int winner(final int pobiMax, final int crongMax) {
        if (pobiMax > crongMax) {
            return WIN_POBI;
        } else if (crongMax > pobiMax) {
            return WIN_CRONG;
        } else {
            return DRAW;
        }
    }

    private int pobiSumMax() {
        return Math.max(this.getDigitSum(this.firstPobiPage()), this.getDigitSum(this.secondPobiPage()));
    }

    private int pobiMulMax() {
        return Math.max(this.getDigitMul(this.firstPobiPage()), this.getDigitMul(this.secondPobiPage()));
    }

    private int crongSumMax() {
        return Math.max(this.getDigitSum(this.firstCrongPage()), this.getDigitSum(this.secondCrongPage()));
    }

    private int crongMulMax() {
        return Math.max(this.getDigitMul(this.firstCrongPage()), this.getDigitMul(this.secondCrongPage()));
    }

    /**
     * 숫자의 각 자릿수를 더하여 반환
     */
    private int getDigitSum(int x) {
        int res = 0;
        while (x > 10) {
            res += x % 10;
            x /= 10;
        }
        return res + x;
    }

    /**
     * 숫자의 각 자릿수를 곱하여 반환
     */
    private int getDigitMul(int x) {
        int res = 1;
        while (x > 10) {
            res *= x % 10;
            x /= 10;
        }
        return res * x;
    }

    private int firstPobiPage() {
        return this.pobi.get(0);
    }

    private int secondPobiPage() {
        return this.pobi.get(1);
    }

    private int firstCrongPage() {
        return this.crong.get(0);
    }

    private int secondCrongPage() {
        return this.crong.get(1);
    }
}
