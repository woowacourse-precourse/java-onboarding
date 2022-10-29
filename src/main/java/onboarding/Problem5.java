package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {

    private static final List<Integer> PAPER_MONEY = List.of(50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1);

    public static List<Integer> solution(int money) {
        List<Integer> answer = countPaperMoney(money);
        return answer;
    }

    private static List<Integer> countPaperMoney(int momey) {
        List<Integer> paperCounts = new ArrayList<>();

        for (int paper : PAPER_MONEY) {
            int maxCount = momey / paper;
            paperCounts.add(maxCount);
            momey -= maxCount * paper;
        }

        return paperCounts;
    }

}