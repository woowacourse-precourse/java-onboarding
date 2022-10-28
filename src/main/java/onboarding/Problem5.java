package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        return getMoneyList(money);
    }

    public static List<Integer> getMoneyList(int money){
        List<Integer> moneyTypeList=new ArrayList<>(
                Arrays.asList(50000,10000,5000,1000,500,100,50,10,1));
        List<Integer> moneyNumList=new ArrayList<>();
        for(int i=0;i<moneyTypeList.size();i++){
            int moneyType = moneyTypeList.get(i);
            moneyNumList.add(money/moneyType);
            money%=moneyType;
        }
        return moneyNumList;
    }
}
