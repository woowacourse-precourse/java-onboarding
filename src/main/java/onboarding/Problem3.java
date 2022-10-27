package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    // number 을 배열에 1 ~ number 까지 나열하는 함수
    private static int[] intToArray(int number) {
        int[] output = new int[number];

        for(int i = 0; i<number; i++) {
            output[i] = i+1;
        }

        return output;
    }

    // 두 자리 이상의 숫자를 int[] 로 분리하는 함수
    private static int[] doubleSplit(int doubleDigits) {
        int[] digits = Stream.of(String.valueOf(doubleDigits).split(""))
                .mapToInt(Integer::parseInt).toArray();

        return digits;
    }
}
