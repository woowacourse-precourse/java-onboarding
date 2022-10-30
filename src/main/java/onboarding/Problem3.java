package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int num=1; num<=number; num++) {
            int[] inputNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();

        }

        return answer;
    }
}
