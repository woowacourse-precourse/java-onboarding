package onboarding.P5;

import java.util.ArrayList;
import java.util.List;
import onboarding.P5.UnitOfMoney;
public class AutomaticBank {

    public static List<Integer> changemoney(int money){
        UnitOfMoney unitOfMoney = new UnitOfMoney();
        List<Integer> ResultList = new ArrayList<>();
        int putmoney = money;
        for(int c: unitOfMoney.unitofmoneylist()){
            int cnt = putmoney / c;
            ResultList.add(cnt);
            putmoney %= c;
        }
        return ResultList;
    }
}
