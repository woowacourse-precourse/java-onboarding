package onboarding;

import java.util.stream.IntStream;

public class Problem3 {
    public static int solution(int number) {
        return IntStream.range(1, number + 1)
                .boxed()
                .map(Problem3::getTheNumberOf369)
                .reduce(0, Integer::sum);
    }

    private static int getTheNumberOf369(int number) {
        int ret = 0;
        while (number != 0) {
            if (is369Number(number % 10)) {
                ret++;
            }
            number /= 10;
        }
        return ret;
    }

    private static boolean is369Number(int number) {
        return number == 3 || number == 6 || number == 9;
    }
}
