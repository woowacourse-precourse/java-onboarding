package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Calculate{
    public List<Integer> getCalculateResult(int money){
        List<Integer> result = new ArrayList<>();
        List<Integer> modMoney = getModMoney();
        int index = 0, cnt = 0;

        while(money != 0){
            if(money >= modMoney.get(index)){
                result.add(money / modMoney.get(index));
                money -= ((money / modMoney.get(index)) * modMoney.get(index));
            } else{
                result.add(0);
            }
            index++;
            cnt++;
        }

        while(cnt != 9){
            result.add(0);
            cnt++;
        }

        return result;
    }

    private List<Integer> getModMoney() {
        List<Integer> modMoney = new ArrayList<>();
        modMoney.add(50000);
        modMoney.add(10000);
        modMoney.add(5000);
        modMoney.add(1000);
        modMoney.add(500);
        modMoney.add(100);
        modMoney.add(50);
        modMoney.add(10);
        modMoney.add(1);
        return modMoney;
    }
}

public class Problem5 {
    private final static Calculate calculate = new Calculate();
    public static List<Integer> solution(int money) {
        return calculate.getCalculateResult(money);
    }
}
