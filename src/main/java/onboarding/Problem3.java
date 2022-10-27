package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Character> numList = new ArrayList<>();
        for (int i = 1; i < number + 1; i++) {
            char[] numArr = splitByDigits(i);
            for (char c : numArr) {
                numList.add(c);
            }
        }
        return calculateCount(numList);
    }

    private static char[] splitByDigits(int i) {
        String numStr = String.valueOf(i);
        return numStr.toCharArray();
    }

    private static int calculateCount(List<Character> numList) {
        int count = 0;
        count += Collections.frequency(numList, '3');
        count += Collections.frequency(numList, '6');
        count += Collections.frequency(numList, '9');
        return count;
    }
}
