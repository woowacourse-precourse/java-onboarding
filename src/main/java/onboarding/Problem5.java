package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int WON_SIZE = 9;

    private static final int FIFTY_THOUSANDS = 50_000;
    private static final int TEN_THOUSANDS = 10_000;
    private static final int FIVE_THOUSANDS = 5_000;
    private static final int THOUSAND = 1_000;
    private static final int FIVE_HUNDREDS = 500;
    private static final int HUNDRED = 100;
    private static final int FIFTY = 50;
    private static final int TEN = 10;
    private static final int ONE = 1;

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        Integer[] wons = new Integer[WON_SIZE];

        int wonCountIndex = 0;
        int moneyIndex = 1;
        for (int wonIndex = 0; wonIndex < WON_SIZE; wonIndex++) {
            int[] countMoney = getCounting(wonIndex, money);

            wons[wonIndex] = countMoney[wonCountIndex];
            money = countMoney[moneyIndex];
        }

        answer = Arrays.asList(wons);

        return answer;
    }

    private static int[] getCounting(int wonIndex, int money) {

        int size = 2;
        int dividedWon = 0;
        int[] countMoney = new int[size];

        if (wonIndex == 0) {
            dividedWon = FIFTY_THOUSANDS;
        } else if (wonIndex == 1) {
            dividedWon = TEN_THOUSANDS;
        } else if (wonIndex == 2) {
            dividedWon = FIVE_THOUSANDS;
        } else if (wonIndex == 3) {
            dividedWon = THOUSAND;
        } else if (wonIndex == 4) {
            dividedWon = FIVE_HUNDREDS;
        } else if (wonIndex == 5) {
            dividedWon = HUNDRED;
        } else if (wonIndex == 6) {
            dividedWon = FIFTY;
        } else if (wonIndex == 7) {
            dividedWon = TEN;
        } else if (wonIndex == 8) {
            dividedWon = ONE;
        }

        countMoney[0] = money / dividedWon;
        countMoney[1] = money - (countMoney[0] * dividedWon);

        return countMoney;
    }

}

