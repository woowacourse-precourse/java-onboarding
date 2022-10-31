package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public final static int MAX_PAPER = 50000;
    private static int withdrawPaper(int bankMoney, int paperMoney) {
        int paperNumber = bankMoney / paperMoney;
        return paperNumber;
    }

    private static int getNextPaper(int paperMoney) {
        String moneyToStr = Integer.toString(paperMoney);

        if (moneyToStr.charAt(0) == '5') {
            return paperMoney / 5;
        } else {
            return paperMoney / 2;
        }
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int bankMoney = money;
        int paperMoney = MAX_PAPER;

        while (true) {
            answer.add(withdrawPaper(bankMoney, paperMoney));
            bankMoney %= paperMoney;

            if (paperMoney == 10) {
                answer.add(bankMoney);
                break;
            }

            paperMoney = getNextPaper(paperMoney);
        }

        return answer;
    }
}