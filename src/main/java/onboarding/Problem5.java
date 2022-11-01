package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int startDiv = 50000;
        int tempMoney = money;
        for (int i=0; i< 8; i++){
            if(i%2==0 && i!=0) startDiv = divideBy2(startDiv);
            else if(i%2==1) startDiv = divideBy5(startDiv);
        }
        return answer;
    }
    public static int divideBy5(int div){
        return div/5;
    }
    public static int divideBy2(int div){
        return div/2;
    }
}
