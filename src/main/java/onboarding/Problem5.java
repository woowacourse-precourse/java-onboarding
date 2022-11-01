package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new java.util.ArrayList<>(Collections.emptyList());
        int [] unit = {50000,10000,5000,1000,500,100,50,10,1};
        for(int i=0; i<9; i++){
            int fullOfNowUnit = division(money,unit[i]);
            money -=fullOfNowUnit;
            answer.add(fullOfNowUnit/unit[i]);
        }
        return answer;
    }
    //단위 순으로 money 구하는 기능
    public static int division(int money, int unit){
        int result = money / unit;
        return result *unit;
    }
}
