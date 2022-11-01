package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static final int[] won = {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        return exchangeMoney(money);
    }

    public static List<Integer> exchangeMoney(int money){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<won.length ; i++){
            result.add(money/won[i]);
            money = money % won[i];
        }
        return result;
    }
}
