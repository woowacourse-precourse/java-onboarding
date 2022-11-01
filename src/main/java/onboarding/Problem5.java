package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        if(money < 1 || money > 1000000){
            return answer;
        }
        int[] unit = {50000,10000,5000,1000,500,100,50,10,1};
        answer = putWallet(money, unit);
        return answer;
    }
    private static List<Integer> putWallet(int money, int[] unit){
        List<Integer> wallet = new ArrayList<>();
        for(int i = 0; i < unit.length; i++){
            wallet.add(money/unit[i]);
            money %= unit[i];
        }
        return wallet;
    }
}
