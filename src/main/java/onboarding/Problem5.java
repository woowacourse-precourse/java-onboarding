package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] unit={50000,10000,5000,1000,500,100,50,10,1};
        return moneyMaxChange(money,unit);
    }
    public static List<Integer> moneyMaxChange(int money,int[] unit){
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<unit.length;i++) {
            answer.add(money / unit[i]);
            money=money%unit[i];
        }
        return answer;
    }
}
