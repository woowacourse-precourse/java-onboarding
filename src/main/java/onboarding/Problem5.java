package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int EMPTY = 0;
    public static List<Integer> solution(int money) {
        List<Integer> answer =changeAsBig(moneyType(),money);
        return answer;
    }
    private static List<Integer> changeAsBig(List<Integer> moneyType, int money) {
        int length = moneyType.size();
        List<Integer> change = new ArrayList<>();
        for(int index =0;index<length;index++){
            int nowType = moneyType.get(index);
            if(nowType>money)change.add(EMPTY);
            if(nowType<=money) {
                change.add(money / nowType);
                money = money % nowType;
            }
        }
        return change;
    }
    private static List<Integer> moneyType(){
        List<Integer> moneyTypeList = new ArrayList<>();
        moneyTypeList.add(50000);
        moneyTypeList.add(10000);
        moneyTypeList.add(5000);
        moneyTypeList.add(1000);
        moneyTypeList.add(500);
        moneyTypeList.add(100);
        moneyTypeList.add(50);
        moneyTypeList.add(10);
        moneyTypeList.add(1);
        return moneyTypeList;
    }

}
