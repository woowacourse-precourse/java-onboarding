package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        return exchangeToCash(money);
    }

    public static List<Integer> exchangeToCash(int money){
        List<Integer> cash = buildCash();
        List<Integer> answer = new ArrayList<Integer>();

        for(int c : cash){
            int num = money / c;
            answer.add(num);
            money %= c;
        }

        return answer;
    }

    public static List<Integer> buildCash(){
        return List.of(50000,10000,5000,1000,500,100,50,10,1);
    }
}
