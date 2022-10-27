package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> ans = new ArrayList<>();
        for (int mt : moneyType){
            if(money==0) ans.add(0);
            else {
                ans.add(Math.floorDiv(money, mt));
                money = Math.floorMod(money, mt);
            }
        }
        return ans;
    }
}
