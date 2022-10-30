package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int[] input_number= Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

        for (int num : input_number) {
            if (num==3 | num==6 | num==9) {
                answer+=1;
            }
        }

        return answer;
    }
}
