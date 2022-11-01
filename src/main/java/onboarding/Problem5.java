package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        int unitOfMoneyArry[] = {50000,10000,5000,1000,500,100,50,10,1};

        answer = addAnswerList(money,unitOfMoneyArry);

        return answer;
    }

    public static int getNumberOfUnit(int money, int unit){
        return money / unit;
    }
    public static List<Integer> addAnswerList(int money,int [] unit){

        List <Integer> answer = new ArrayList<>();

        while(money != 0){
            for(int i = 0; i < unit.length; i++){
                if(getNumberOfUnit(money,unit[i]) == 0){
                    answer.add(0);
                }
                else{
                    answer.add(getNumberOfUnit(money,unit[i])) ;
                    money -= getNumberOfUnit(money,unit[i]) * unit[i];
                }
            }
        }
        return answer;
    }
}
