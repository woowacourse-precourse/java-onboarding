package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int currentNumber = 1; currentNumber <= number; currentNumber++) {
            answer += countThreeSixNine(currentNumber);
        }

        return answer;
    }

    /*
     * 주어진 문자열에 존재하는 3, 6, 9의 개수를 반환
     * 문자열을 한 자리씩 정수로 변환해서 0이 아니고, 정수 % 3 == 0인 경우 카운트 증가
     *
     * @return int
     * */
    private static int countThreeSixNine(int currentNumber) {
        return (int) Arrays.stream(String.valueOf(currentNumber).split(""))
                .mapToInt(Integer::parseInt)
                .filter(number -> number == 3 || number == 6 || number == 9)
                .count();
    }
}
