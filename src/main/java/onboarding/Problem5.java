package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem5 {

    public static List<Integer> solution(int money) {
        return new Solver5(money).solve();
    }
}

/*
 * 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
 * 각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열
 * 1 <= money <= 1,000,000
 */
class Solver5 {

    private static final int[] MONEY_UNITS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 1 };

    private int totalMoney;
    private int unitIdx;
    private final int[] unitCounter = new int[9];

    public Solver5(final int money) {
        this.totalMoney = money;
        Arrays.fill(this.unitCounter, 0, 9, 0); // fill with zero
    }

    public List<Integer> solve() {
        while (this.totalMoney > 0) {
            findMaximumUnitIdx();
            changeMoney();
        }
        return list();
    }

    /**
     * 변환할 수 있을만큼 환전
     */
    private void changeMoney() {
        int count = this.totalMoney / MONEY_UNITS[this.unitIdx];
        this.unitCounter[this.unitIdx] += count;
        this.totalMoney -= MONEY_UNITS[this.unitIdx] * count;
    }

    private void findMaximumUnitIdx() {
        int idx;
        for (idx = 0; MONEY_UNITS[idx] > totalMoney; idx++);

        this.unitIdx = idx;
    }

    // int[] -> List<Integer>
    private List<Integer> list() {
        return IntStream.of(this.unitCounter).boxed().collect(Collectors.toList());
    }
}
