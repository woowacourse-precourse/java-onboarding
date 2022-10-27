package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static List<Integer> getIntegersUnderNumber(int number) {
        List<Integer> integersUnderNumber = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            integersUnderNumber.add(i);
        }
        return integersUnderNumber;
    }

    private static char[] getCharsOfNumber(int number) {
        String numberToString = String.valueOf(number);
        char[] charsOfNumber = numberToString.toCharArray();
        return charsOfNumber;
    }

    //Return Claps Of Sequence
    private static int getClapsOfSequence(char[] charsOfSequence) {
        int claps =0;
        for (char digit : charsOfSequence) {
            claps = getClapsOfDigit(claps, digit);
        }
        return claps;
    }

    //Return Clap of digit
    private static int getClapsOfDigit(int claps, char digit) {
        //digit is char -> '3' == 51 in decimal, '6' == 54 in decimal, '9'== 57 in decimal
        if (digit == 51 || digit == 54 || digit == 57) {
            claps++;
        }
        return claps;
    }
}
