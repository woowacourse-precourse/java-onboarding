package onboarding.problem3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ApplauseGame {
    private static final int MIN = 1;
    private static final int MAX = 10_000;

    public static int start(int number) {
        ApplauseParameter applauseParameter = new ApplauseParameter(number);
        int clap = 0;
        for (int i = 0; i < applauseParameter.getNumbers().length(); i++) {
            clap = addClap(applauseParameter.getNumbers(), clap, i);
        }
        return clap;
    }
    private static int addClap(String numbers, int count, int i) {
        if (isClap(numbers, i)) {
            count++;
        }
        return count;
    }



    private static boolean isClap(String string, int i) {
        return string.charAt(i) == '3' || string.charAt(i) == '6' || string.charAt(i) == '9';
    }

}
