package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static List<Character> clapList;

    public static int solution(int number) {
        clapList = new ArrayList<>();
        clapList.add('3');
        clapList.add('6');
        clapList.add('9');
        return sumOfClapCount(number);
    }

    private static int sumOfClapCount(int number) {
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
            if (clapList.contains(strOfCurrentNumber.charAt(i))) {
                clapCount++;
            }
        }
        return clapCount;
    }
}
