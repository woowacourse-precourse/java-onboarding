package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        for(int i=0;i<moneyUnitList.size();i++){
            int howMany = moneyUnitCount(money,moneyUnitList.get(i));
        }
        return list;
    }
    public static int moneyUnitCount(int money,int moneyUnit){
        int howMany =0;
        while(money >=moneyUnit){
            howMany++;
        }
        return howMany;
    }

    public static List<Integer> moneyInitList(List<Integer> list){
        list = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        return list;
    }




}
ㅎ