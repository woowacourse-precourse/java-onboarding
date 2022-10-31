package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Problem1 {
    private final static int EXCEPTION = -1;
    private final static int DRAW = 0;
    private final static int WIN_POBI = 1;
    private final static int WIN_CRONG = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }

    private static int getBiggerNumberAtAddOrMultiply(int number) {
        int[] oneLetterNumbers = getOneLetterNumbers(number);

        return Math.max(addNumbers(oneLetterNumbers), multiplyNumbers(oneLetterNumbers));
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

    /**
     * 입력된 모든 숫자 곱하기
     * @param numbers 숫자 집합
     * @return 결과값
     */
    private static int multiplyNumbers(int[] numbers) {
        int number = 1;

        for (int n: numbers) {
            number *= n;
        }

        return number;
    }

    /**
     * 숫자를 한자리씩 분할
     * @param number 페이지 번호
     * @return 한자리씩 분할된 페이지 번호 집합
     */
    private static int[] getOneLetterNumbers(int number) {
        List<Integer> oneLetterNumber = new ArrayList<>();

        while (number > 0) {
            oneLetterNumber.add(number % 10);
            number /= 10;
        }

        Collections.reverse(oneLetterNumber);

        return oneLetterNumber.stream().mapToInt(i -> i).toArray();
    }

}