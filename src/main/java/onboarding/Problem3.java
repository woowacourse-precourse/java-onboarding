package onboarding;

import java.util.stream.IntStream;

public class Problem3 {

    public static int get369Count(int number) {
        int cnt = 0;

        while (number > 0) {
            int currDigit = number % 10;
            if (currDigit == 3 || currDigit == 6 || currDigit == 9) cnt++;
            number /= 10;
        }

        return cnt;
    }
    public static int solution(int number) {
        
        return IntStream.range(1, number+1)
                .reduce((total, num) -> total + get369Count(num))
                .orElse(0);
    }
}
