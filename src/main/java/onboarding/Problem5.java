package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getMinPaperMoney(money);
    }

    private static List<Integer> getMinPaperMoney(int money){
        final int[] MONETARY_UNIT =
                new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> resultUnit = new ArrayList<>();

        for (int i=0; i<MONETARY_UNIT.length; i++){
            resultUnit.add(money / MONETARY_UNIT[i]);
            money %= MONETARY_UNIT[i];
        }

        return resultUnit;
    }
}
