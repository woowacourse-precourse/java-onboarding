package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public static List<Integer> solution(int money) {

        List<Integer> list = new ArrayList<>();
        int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < arr.length; i++) {
            if (money / arr[i] != 0) {
                list.add(money / arr[i]);
            }else{
                list.add(0);
            }
            money %= arr[i];
        }

        return list;
    }
}
