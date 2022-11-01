package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int[] numArr = new int[number];

        for (int i = 0; i < number; i++) {
            numArr[i] = i+1;
        }

        String str = Arrays.toString(numArr).replaceAll("[^0-9]", "");

        int result = 0;

        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9')
                result++;

        return result;
    }
}
