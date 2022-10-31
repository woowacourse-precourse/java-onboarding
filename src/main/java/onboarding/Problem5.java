package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        Integer[] cashes = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        List<Integer> convert = new ArrayList<>();

        for(int i = 0; i < cashes.length; i++){
            int cash = cashes[i];
            convert.add(money/cash);
            money = money%cash;
        }
        return convert;
    }
}
