package onboarding;

import java.util.ArrayList;

import static java.util.Arrays.*;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = countClap(number);
        return answer;
    }

    static int countClap(int number) {
        String threeSixNine = "369";
        int count = 0;
        for (int i = 1; i <= number; i++) {
            String num = Integer.toString(i);
            for (int j = 0; j < num.length(); j++) {
                if (threeSixNine.contains(Character.toString(num.charAt(j)))) {
                    count++;
                }
            }
        }
        return count;
    }
}
