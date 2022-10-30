package onboarding;

import java.util.ArrayList;

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
}
