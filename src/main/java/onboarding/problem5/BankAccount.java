package onboarding.problem5;

import java.util.LinkedList;
import java.util.List;

public class BankAccount {

    public List<Integer> withdraw(int money){
        List<Integer> moneys = new LinkedList<>();
        int num;
        for(Money unitMoney : Money.values()){
            num = money/ unitMoney.amount();
            moneys.add(num);
            money -= unitMoney.totalAmount(num);
        }
        return moneys;
    }

}
