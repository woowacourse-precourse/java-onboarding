package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countThreeSixNine(eachDigit(i));
        }
        return answer;
    }

    public static int[] eachDigit(int num) {
        return Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
    }

    public static int countThreeSixNine(int[] arr) {
        int clap = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 3 || arr[i] == 6 || arr[i] == 9) {
                clap++;
            }
        }
        return clap;
    }
}
