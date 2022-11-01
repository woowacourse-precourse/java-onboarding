package onboarding.feature3;

import java.util.List;

public class ClapValidator {
    public static int numberOfClaps (int[] digitsOfNumber, List<Integer> clapNumbers) {
        int counting = 0;
        for (int digit : digitsOfNumber) {
            if (clapNumbers.contains(digit)) {
                counting++;
            }
        }
        return counting;
    }
}
