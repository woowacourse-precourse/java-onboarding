package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> moneyList = new ArrayList<>();
        moneyList = moneyInitList(moneyList);
        answer = initList(answer);

        return answer;
    }
    public static List<Integer>  initList(List<Integer> list){
        for(int i=0;i<9;i++){
            list.add(0);
        }
        return list;
    }
    public static List<Integer> moneyInitList(List<Integer> list){
        list = Arrays.asList(50000,10000,5000,1000,500,100,50,10,1);
        return list;
    }
   

}
