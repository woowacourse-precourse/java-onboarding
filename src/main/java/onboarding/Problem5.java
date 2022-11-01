package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] price= {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        ArrayList<Integer> wallet = new ArrayList<>();
        for(int i=0; i< price.length; i++){
            wallet.add(money/price[i]);
            money = money%price[i];
        }
        
        return wallet;
    }
}
