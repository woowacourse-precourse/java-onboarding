package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public final static int MAX_PAPER = 50000;
    private static int withdrawPaper(int bankMoney, int paperMoney) {
        int paperNumber = bankMoney / paperMoney;
        return paperNumber;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int bankMoney = money;
        int paperMoney = MAX_PAPER;

        return answer;
    }
}