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

    // 각 숫자마다 3, 6, 9 가 몇 번 들어가는지 판단하고, 그 개수를 리턴하는 함수
    private static int judgeNumber(int input) {
        // 한 자리수 숫자일 때 판단
        if(input < 10 && (input == 3 || input == 6 || input == 9)) {
            return 1;
        }

        // 두 자리 이상 숫자일 때 판단
        int[] doubleDigits;
        int count = 0;
        doubleDigits = doubleSplit(input);
        for(int i = 0; i<doubleDigits.length; i++) {
            if(doubleDigits[i] == 3 || doubleDigits[i] == 6 || doubleDigits[i] == 9) {
                count++;
            }
        }

        return count;
    }
}
