package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

    public static int solution(int number) {
        return new Solver3(number).solve();
    }
}

class Solver3 {

    private final int limitNumber;
    private int totalClaps = 0;

    public Solver3(final int number) {
        this.limitNumber = number;
    }

    public int solve() {
        // endExclusive여서 +1 함
        IntStream.range(1, limitNumber + 1).forEach(this::addClap);
        return this.totalClaps;
    }

    /**
     * 각 자릿수의 수가 3의 배수인 경우 손뼉을 1회씩 추가한다.
     */
    private void addClap(int x) {
        int claps = 0;
        int curDigit;

        for (; x > 0; x /= 10) {
            curDigit = x % 10;
            if (curDigit == 0) continue;
            if (curDigit % 3 == 0) claps++;
        }
        this.totalClaps += claps;
    }
}
