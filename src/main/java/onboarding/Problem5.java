package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int currency[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        return moneyToCurrency(money, currency);
    }
    static List<Integer> moneyToCurrency(int money, int currency[]){
        List<Integer> currencyCount = new ArrayList<>();
        for(int i=0;i<currency.length;i++){
            if(money < currency[i]) {
                currencyCount.add(0);
            }
            if(money >= currency[i]) {
                currencyCount.add(money / currency[i]);
                money -= currencyCount.get(i) * currency[i];
            }
        }
        return currencyCount;
    }
}
