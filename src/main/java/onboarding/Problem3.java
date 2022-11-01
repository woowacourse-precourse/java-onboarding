package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;
        for (int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            clap += (int) Arrays.stream(str.split(""))
                    .filter(s -> {
                        int n = Integer.parseInt(s);
                        return n == 3 || n == 6 || n == 9;
                    })
                    .count();
        }
        return clap;
    }
}
