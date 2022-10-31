package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyPaper = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> answer = moneyCount(money, moneyPaper);
        return answer;
    }
    public static List<Integer> moneyCount(int money, int[] moneyPaper){
        List<Integer> moneyCount = new ArrayList<>();

        for (int len = moneyPaper.length, i=0; i<len;i++){
            int count = money/moneyPaper[i];
            moneyCount.add(count);
            money-=moneyPaper[i]*count;
        }
        return moneyCount;
    }
}
