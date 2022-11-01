package onboarding;

import onboarding.feature3.ClapValidator;
import onboarding.feature3.NumberSeparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Integer> clapNumbers = new ArrayList<>(Arrays.asList(3, 6, 9));
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int[] digitsOfNumber = NumberSeparator.getDigits(i);
            answer += ClapValidator.numberOfClaps(digitsOfNumber, clapNumbers);
        }
        return answer;
    }
}
