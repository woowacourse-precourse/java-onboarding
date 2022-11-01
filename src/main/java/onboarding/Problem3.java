package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;
        String checkStr = "3, 6, 9";

        for (int i = 1; i <= number; i++) {
            int temp = (int) Arrays.stream(String.valueOf(i).split(""))
                    .filter(checkStr::contains)
                    .count();
            result += temp;
        }

        return result;
    }
}
