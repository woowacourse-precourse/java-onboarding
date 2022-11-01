package onboarding.problem5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Counter {
    private static final int[] BILLS = new int[] {50_000, 10_000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> countBills(int money){
        int[] result = new int[9];
        for(int idx = 0; idx<BILLS.length;idx++){
            int count = money / BILLS[idx];
            result[idx] = count;
            money = money % BILLS[idx];
        }
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }
}
