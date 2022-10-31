package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Integer> integersUnderNumber = getIntegersSmallerThanNumber(number);
        int totalClaps = 0;

        for (int sequence : integersUnderNumber) {
            char[] charsOfInteger = getIntegerElementsWithCharArray(sequence);
            int claps = getClaps(charsOfInteger);
            totalClaps = totalClaps + claps;
        }

        return totalClaps;
    }

    private static List<Integer> getIntegersSmallerThanNumber(int number) {
        List<Integer> integersUnderNumber = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            integersUnderNumber.add(i);
        }

        return integersUnderNumber;
    }

    private static char[] getIntegerElementsWithCharArray(int sequence) {
        String sequenceToString = String.valueOf(sequence);
        return sequenceToString.toCharArray();
    }

    private static int getClaps(char[] digits) {
        int claps = 0;
        for (char digit : digits) {
            claps += makeClap(digit);
        }

        return claps;
    }

    private static int makeClap(char digit) {
        //digit is char -> '3' == 51 in decimal, '6' == 54 in decimal, '9'== 57 in decimal
        if (digit == 51 || digit == 54 || digit == 57) {
            return 1;
        }
        return 0;
    }
}
