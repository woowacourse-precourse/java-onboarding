package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> moneyUnits = List.of(50_000,10_000,5_000,1_000,500,100,50,10,1);
    public static List<Integer> solution(int money) {
        return withdraw(money);
    }

    public static List<Integer> withdraw(int money){
        List<Integer> wallet = new ArrayList<>();
        for (int i=0;i<moneyUnits.size();i++){
            int share = money / moneyUnits.get(i);
            wallet.add(i,share);
            money = money % moneyUnits.get(i);
        }
        return wallet;
    }
}
