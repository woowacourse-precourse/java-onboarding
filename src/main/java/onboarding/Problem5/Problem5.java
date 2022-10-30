package onboarding.Problem5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    static final int[] arr = {50_000,10_000,5_000,1_000,500,100,50,10,1};
    private static List<Integer> changeMoney(int money)
    {
        List<Integer> changedCount = new LinkedList<>();
        for(int i = 0 ; i < arr.length;i++)
        {
            changedCount.add(money/arr[i]);
            money %= arr[i];
        }
        return changedCount;
    }
    public static List<Integer> solution(int money) {

        return changeMoney(money);
    }
}
