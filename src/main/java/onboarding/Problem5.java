package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    static int[] coin = { 50000, 10000, 5000, 1000, 500, 100 , 50, 10, 1};

    public static List<Integer> change(int money){
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<coin.length; i++){
            list.add(i, money/coin[i]);
            money %= coin[i];
        }
        return list;
    }

    public static List<Integer> solution(int money) {
        return change(money);
    }
}
