package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = playGame(number);
        return answer;
    }

    private static int playGame(int number) {
        int result = 0;

        for(int num = 1; num <= number; num++) {
            int[] numberList = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
            for (int element : numberList) {
                if(element == 3 || element == 6 || element == 9) {
                    result += 1;
                }
            }
        }

        return result;
    }
}
