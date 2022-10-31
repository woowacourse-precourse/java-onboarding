package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1 ; i <= number ; i++) {
            answer += Stream.of(String.valueOf(i).split(""))
                    .map(Integer::parseInt)
                    .filter(num -> num == 3 || num == 6 || num == 9)
                    .count();
        }
        return answer;
    }
}
