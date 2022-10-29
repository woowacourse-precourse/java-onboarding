package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int [] moneyType = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int [] count = new int[9];
        for (int i=0; i<moneyType.length; i++){
            count[i] = money / moneyType[i];
            money %= moneyType[i];
        }

        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }
}
