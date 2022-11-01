package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return checkAmount(money);
    }

    private static List<Integer> checkAmount(int money){
        int result = 0;
        int[] arr = {50000,10000,5000,1000,500,100,50,10,1};
        List<Integer> amount = new ArrayList<>(Collections.emptyList());

        for(int i: arr){
            result = money / i;
            money = money % i;
            amount.add(result);
        }
        return amount;
    }
}
