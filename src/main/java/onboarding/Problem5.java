package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        ArrayList<Integer> moneyList = getMoneyList();
        List<Integer> answer = getAnswer(money, moneyList);
        return answer;
    }
    public static ArrayList<Integer> getMoneyList(){
        ArrayList<Integer> moneyList = new ArrayList<>(List.of(50000,10000,5000,1000,500,100,50,10,1));
        return moneyList;
    }

    public static List<Integer> getAnswer(int money, ArrayList<Integer> moneyList){
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < moneyList.size(); i++){
            int num = money / moneyList.get(i);
            money -= (num * moneyList.get(i));
            answer.add(num);
        }
        return answer;
    }
}
