package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    private final static int EXCEPTION = -1;
    private final static int DRAW = 0;
    private final static int WIN_POBI = 1;
    private final static int WIN_CRONG = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

    /**
     * 입력된 모든 숫자 더하기
     * @param numbers 숫자 집합
     * @return 결과값
     */
    private static int addNumbers(int[] numbers) {
        int number = 0;

        for (int n: numbers) {
            number += n;
        }

        return number;
    }



}