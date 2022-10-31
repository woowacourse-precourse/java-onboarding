package onboarding.prob1.domain;

import onboarding.prob1.policy.CalculateScore;

public class MultiplyCalculator implements CalculateScore {

    @Override
    public Integer getScore(Integer number1, Integer number2) {
        int a = getMultiply(number1);
        int b = getMultiply(number2);
        return Math.max(a, b);
    }

    final int getMultiply(Integer number) {
        String s = number.toString();
        int total = Integer.parseInt(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            total *= Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return total;
    }
}
