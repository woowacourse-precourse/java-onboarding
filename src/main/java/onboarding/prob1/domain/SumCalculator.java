package onboarding.prob1.domain;

import onboarding.prob1.policy.CalculateScore;

public class SumCalculator implements CalculateScore {

    @Override
    public Integer getScore(Integer number1, Integer number2) {
        int a = getSum(number1);
        int b = getSum(number2);
        return Math.max(a, b);
    }

    final int getSum(Integer number) {
        String s = number.toString();
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            total += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return total;
    }
}
