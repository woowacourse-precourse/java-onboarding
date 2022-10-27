package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final List<Integer> MONEYLIST = List.of(50000,10000,5000,1000,500,100,50,10,1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        answer = MoneyLoop(money);
        return answer;
    }
    private static int divideMoney(int money, int divMoney){
        return Math.floorDiv(money,divMoney);
    }
    private static int moduloMoney(int money, int divMoney){
        return Math.floorMod(money,divMoney);
    }
    private static List<Integer> MoneyLoop(int money){
        List<Integer> list = new ArrayList<>();
        for (Integer divmoney : MONEYLIST) {
            list.add(divideMoney(money, divmoney));
            money = moduloMoney(money,divmoney);
        }
        return list;
    }
}
