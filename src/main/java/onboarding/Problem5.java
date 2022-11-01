package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CalculateMoney{
    private List<Integer> moneyUnits = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1); // default 값 한국기준

    public List<Integer> calculateMoneyByUnits(int money){
        List<Integer> result = new ArrayList<>();
        int share; // 몫 저장
        for(Integer moneyUnit: moneyUnits){//각 돈 단위로 남은 금액을 나눔
            share = money/moneyUnit;
            result.add(share);
            money = money%moneyUnit;
        }
        return result;
    }

    public void setMoneyUnits(List<Integer> moneyUnits) {// 단위 변경
        this.moneyUnits = moneyUnits;
    }
}
public class Problem5 {
    public static List<Integer> solution(int money) {
        CalculateMoney calculateMoney = new CalculateMoney();
        List<Integer> answer = calculateMoney.calculateMoneyByUnits(money);
        return answer;
    }
}
