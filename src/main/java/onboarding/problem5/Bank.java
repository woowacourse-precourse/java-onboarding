package onboarding.problem5;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private MoneyUnit moneyUnit;

    public Bank(MoneyUnit moneyUnit){
        this.moneyUnit = moneyUnit;
    }

    public List<Integer> withdraw(int money){
        List<Integer> answer = new ArrayList<>();
        int remainingMoney = money;

        for (int moneyUnit : moneyUnit.getUnit()){
            int unitCount = remainingMoney / moneyUnit;
            answer.add(unitCount);
            remainingMoney -= moneyUnit * unitCount;
        }

        return answer;
    }
}
