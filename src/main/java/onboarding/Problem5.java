package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        answer = reAnswerList(answer,money);
        return answer;
    }
    public static List<Integer> reAnswerList(List<Integer>list ,int money){
        List<Integer> moneyUnitList = new ArrayList<>();
        moneyUnitList = moneyInitList(moneyUnitList);
        checkEachMoneyUnit(list, money, moneyUnitList);
        return list;
    }
    private static void checkEachMoneyUnit(List<Integer> list, int money, List<Integer> moneyUnitList) {
        for(int i = 0; i< moneyUnitList.size(); i++){
            int howMany = moneyUnitCount(money, moneyUnitList.get(i));
            list.add(howMany);
            money -= (howMany* moneyUnitList.get(i));
        }
    }
    public static int moneyUnitCount(int money,int moneyUnit){
        int howMany =0;
        while(money >=moneyUnit){
            howMany++;
            money -=moneyUnit;
        }
        return howMany;
    }
    public static List<Integer> moneyInitList(List<Integer> list){
        list = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        return list;
    }




}
