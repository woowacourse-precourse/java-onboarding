package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static List<Character> claps;

    public static int solution(int number) {
        claps = new ArrayList<>();
        claps.add('3');
        claps.add('6');
        claps.add('9');
        return sumClapCount(number);
    }

    private static int sumClapCount(int number) {
        int clapCount = 0;
        for (int currentNumber = 3; currentNumber <= number; currentNumber++) {
            String strOfCurrentNumber = String.valueOf(currentNumber);
            clapCount += countClap(strOfCurrentNumber);
        }
        return clapCount;
    }

    private static int countClap(String strOfCurrentNumber) {
        int clapCount = 0;
        for (int i = 0; i < strOfCurrentNumber.length(); i++) {
            if (claps.contains(strOfCurrentNumber.charAt(i))) {
                clapCount++;
            }
        }
        return clapCount;
    }
}
