package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int[] pocket = new int[moneyType.length];
        Arrays.fill(pocket,0);

        for (int idx=0; idx<moneyType.length; idx++){
            pocket[idx]=Math.floorDiv(money, moneyType[idx]);
            money = Math.floorMod(money, moneyType[idx]);
            if(money==0)break;
        }
        return Arrays.asList(
                Arrays.stream(pocket)
                        .boxed()
                        .toArray(Integer[]::new)
                );
    }
}
