package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static final int EMPTY = 0;
    private static final int ERROR = -100;
    public static List<Integer> solution(int money) {
        List<Integer> answer =changeAsBig(moneyType(),money);
        return answer;
    }
    private static List<Integer> changeAsBig(List<Integer> moneyType, int money) {
        int length = moneyType.size();
        List<Integer> changeList = new ArrayList<>();
        for(int index =0;index<length;index++){
            int nowType = moneyType.get(index);
            money = change(changeList,nowType,money);
        }
        return changeList;
    }
    private static int change(List<Integer> changeList, int nowType, int money){
        if(nowType>money){
            changeList.add(EMPTY);
            return money;
        }
        if(nowType<=money){
            changeList.add(money/nowType);
            return money%nowType;
        }
        return ERROR;
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
