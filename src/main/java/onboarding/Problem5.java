package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    private int[] currency;
    public Problem5(){
         currency = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        Problem5 p5 = new Problem5();
        for(int i = 0; i < p5.currency.length; ++i){
            answer.add(money/p5.currency[i]);
            money %= p5.currency[i];
        }
        return answer;
    }
}
