package onboarding;

import java.util.ArrayList;
import java.util.Collections;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369ByNumber(i);
        }
        return answer;
    }

    static int count369ByNumber(int number) {
        ArrayList<String> arrayListOfNumber = convertNumberToArrayList(number);
        int count = countByArrayListOfNumber(arrayListOfNumber);
        return count;
    }

    static int countByArrayListOfNumber(ArrayList<String> arrayListOfNumber) {
        int count = 0;
        count += Collections.frequency(arrayListOfNumber, "3");
        count += Collections.frequency(arrayListOfNumber, "6");
        count += Collections.frequency(arrayListOfNumber, "9");
        return count;
    }
}
