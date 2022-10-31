package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static int divide(int money, int paper) {
        return money/paper;
    }

    public static int remainder(int money, int paper) {
        return money%paper;
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int[] paperMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i=0; i<paperMoney.length; i++) {
            int paperCnt = divide(money, paperMoney[i]);
            money = remainder(money, paperMoney[i]);
            answer.add(paperCnt);
        }
        return answer;
    }
}