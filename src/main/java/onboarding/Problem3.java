package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static int solution(int number) {
        List<Integer> newNumber = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            int num = i;
            while (num > 0) {
                newNumber.add(num % 10);
                num /= 10;
            }
        }
        int count = 0;

        for (int i : newNumber) {
            if (i == 3 || i == 6 || i == 9) {
                count++;
            }
        }
        return count;
    }

}
