package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    // https://stackoverflow.com/questions/21714886/can-arraylist-be-used-for-readonly-purpose-in-multithreaded-environment
    // https://stackoverflow.com/questions/28298427/if-i-have-fixed-size-data-should-i-go-for-array-and-arraylist
    private static final int[] UNITS = new int[] {
        50_000, 10_000, 5_000, 1_000, 500, 100, 50, 10, 1
    };

    public static List<Integer> solution(int money) {
        // https://stackoverflow.com/questions/5600668/how-can-i-initialize-an-arraylist-with-all-zeroes-in-java
        List<Integer> answer = new ArrayList<>(Collections.nCopies(UNITS.length, 0));
        for (int i = 0, j = money; j != 0; i++) {
            if (j >= UNITS[i]) {
                answer.set(i, j / UNITS[i]);
                j %= UNITS[i];
            }
        }
        return answer;
    }

}
