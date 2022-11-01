package onboarding;

import java.util.Stack;

public class Problem3 {
    public static int solution(int number) {
        final int ERROR = -1;
        if (violation(number)) return ERROR;
        return count(number);
    }

    static boolean violation(int number) {
        return number < 1 || number > 10000;
    }

    static Stack<Digit> digits(int number) {
        Stack<Digit> digits = new Stack<>();
        int positionNumber = 0;
        int weight = 1;
        while (number > 0) {
            digits.push(new Digit(number % 10, weight, positionNumber));
            positionNumber++;
            weight *= 10;
            number /= 10;
        }
        return digits;
    }

    static int count(int number) {
        int answer = 0;
        Stack<Digit> digits = digits(number);
        while (!digits.isEmpty()) {
            Digit digit = digits.pop();
            if (digit.digit == 0) continue;
            answer += digit.digit * digit.positionNumber * digit.weight * 3 / 10;
            answer += (digit.digit - 1) / 3 * digit.weight;
            number -= digit.digit * digit.weight;
            if (digit.digit % 3 == 0) answer += (number + 1);
        }
        return answer;
    }

    static class Digit {
        int digit;
        int weight;
        int positionNumber;

        public Digit(int digit, int weight, int positionNumber) {
            this.digit = digit;
            this.weight = weight;
            this.positionNumber = positionNumber;
        }
    }
}
