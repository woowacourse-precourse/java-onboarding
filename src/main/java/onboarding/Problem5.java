package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        int[] cashList = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        // 1. Initialize the list with 0
        for (int i = 0; i < 9; i++) {
            answer.add(0);
        }

        // 2. Withdraw money as light as possible
        for (int i = 0; i < 9; i++) {
            int share = money / cashList[i];    // Divide money by each cash
            answer.set(i, share); // Set the value of the answer array
            money -= share * cashList[i];   // Change the value of money
        }

        return answer;
    }
}
