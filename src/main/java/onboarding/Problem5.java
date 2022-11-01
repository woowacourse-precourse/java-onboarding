package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private static int[] moneyEx = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    public static List<Integer> solution(int money) {
        List<Integer> checklist = new ArrayList<Integer>();
        return calculateMoney(money, checklist);
    }
    private static List<Integer> calculateMoney(int money, List<Integer> list){
        int calmoney = 0;
        for(int i=0; i<moneyEx.length; i++){
            calmoney = money/moneyEx[i];
            list.add(calmoney);
            money -= calmoney * moneyEx[i];
        }
        return list;
    }
}