package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    static List<Integer> coinList= Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>(Collections.emptyList());
        for(int i=0;i<coinList.size();i++){
            int coin=coinList.get(i);
            //System.out.print(money/coin);
            answer.add(money/coin);
            money%=coin;
        }
        return answer;
    }
}
