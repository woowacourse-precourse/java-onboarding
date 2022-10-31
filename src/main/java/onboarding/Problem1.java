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

    /**
     * 페이지 값이 2개 주어졌는지 확인
     * @param pages 페이지 정보
     * @return 결과
     */
    private static boolean validateTwoPagesHave(List<String> pages) {
        if (pages.size() != 2) {
            System.out.println("페이지 값이 2개가 아닙니다.");
            return false;
        }

        return true;
    }

    /**
     * 두 참가자의 승자 가리기
     * @param pobi 포비의 페이지 정보
     * @param crong 크롱의 페이지 정보
     * @return 결과
     */
    private static int getResult(List<Integer> pobi, List<Integer> crong) {
        int pobiNumber = getBiggerNumberAtPages(pobi);
        int crongNumber = getBiggerNumberAtPages(crong);
        int compareTwoNumbers = Integer.compare(pobiNumber, crongNumber);

        switch (compareTwoNumbers) {
            case -1: return WIN_CRONG;
            case 0: return DRAW;
            case 1: return WIN_POBI;
            default: return EXCEPTION;
        }
    }

    /**
     * 페이지 정보를 기반으로 계산된 2개의 수를 비교
     * @param pages 페이지 정보
     * @return 두 페이지 중 가장 큰 수
     */
    private static int getBiggerNumberAtPages(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int bestLeftPage = getBiggerNumberAtAddOrMultiply(leftPage);
        int bestRightPage = getBiggerNumberAtAddOrMultiply(rightPage);

        return Math.max(bestLeftPage, bestRightPage);
    }

    /**
     * 곱하거나 더한 수 중 큰 수 구하기
     * @param number 숫자
     * @return 큰 수
     */
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