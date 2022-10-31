package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static int moneyUnit[]={50000,10000,5000,1000,500,100,50,10,1};

    public static boolean compareMoney(int money, int unit){
        if(money>=unit)
            return true;
        else
            return false;
    }

    public static List<Integer> makeMoneyToUnit(int money){
        int remainMoney=money;
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<moneyUnit.length;i++){
            if(compareMoney(remainMoney, moneyUnit[i])){
                int share=remainMoney/moneyUnit[i];
                remainMoney-=share*moneyUnit[i];
                result.add(i,share);
            }else
                result.add(i,0);

        }
        return result;
    }
    public static List<Integer> solution(int money) {

        return makeMoneyToUnit(money);
    }
}
