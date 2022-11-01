package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        // 변수 초기화
        int finalClapCount = 0;

        // 1부터 주어진 숫자까지 반복
        for (int i = 1; i<=number; i++) {
            int[] arrNum = splitEachNumbers(i);
            int clapCount = countTargetNumber(arrNum);
            finalClapCount = finalClapCount + clapCount;
        }

        return finalClapCount;
    }

    /**
     * 숫자를 각 자리수별 숫자로 나눈다.
     * @param number 입력된 숫자
     * @return 배열
     */
    private static int[] splitEachNumbers(int number) {
        return Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
    }

    /**
     * 해당 숫자에 3, 6, 9가 있으면 clapCount에 1을 더한다.
     * @param arrNum 배열
     * @return 해당 숫자에서 박수 친 횟수
     */
    private static int countTargetNumber(int[] arrNum) {
        int clapCount = 0;
        for (int i = 0; i<arrNum.length; i++) {
            if (arrNum[i] == 3 || arrNum[i] == 6 || arrNum[i] == 9) {
                clapCount = clapCount + 1;
            }
        }
        return clapCount;
    }
}
