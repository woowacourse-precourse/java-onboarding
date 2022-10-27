package onboarding;

import java.util.*;

class Problem1 {

    static final int LEFT_INDEX_IN_LIST = 0;
    static final int RIGHT_INDEX_IN_LIST = 1;
    static final int NUMBER_OF_CANDIDATES_FOR_SCORE = 4;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isImpossiblePages(pobi) || isImpossiblePages(crong)) {
            return ResultType.EXCEPTION.getResult();
        }

        Set<Integer> candidateNumbersOfPobiMaxScore = new HashSet<>(NUMBER_OF_CANDIDATES_FOR_SCORE);

        String StringOfPobiLeftPage = convertIntToString(pobi.get(LEFT_INDEX_IN_LIST));
        candidateNumbersOfPobiMaxScore.add(getSumPageDigits(StringOfPobiLeftPage));
        candidateNumbersOfPobiMaxScore.add(getMultipliedPageDigits(StringOfPobiLeftPage));

        String StringOfPobiRightPage = convertIntToString(pobi.get(RIGHT_INDEX_IN_LIST));
        candidateNumbersOfPobiMaxScore.add(getSumPageDigits(StringOfPobiRightPage));
        candidateNumbersOfPobiMaxScore.add(getMultipliedPageDigits(StringOfPobiRightPage));

        int pobiScore = getMaxNumberOfList(candidateNumbersOfPobiMaxScore);

        Set<Integer> candidateNumbersOfCrongMaxScore = new HashSet<>(NUMBER_OF_CANDIDATES_FOR_SCORE);

        String StringOfCrongLeftPage = convertIntToString(crong.get(LEFT_INDEX_IN_LIST));
        candidateNumbersOfCrongMaxScore.add(getSumPageDigits(StringOfCrongLeftPage));
        candidateNumbersOfCrongMaxScore.add(getMultipliedPageDigits(StringOfCrongLeftPage));

        String StringOfCrongRightPage = convertIntToString(crong.get(RIGHT_INDEX_IN_LIST));
        candidateNumbersOfCrongMaxScore.add(getSumPageDigits(StringOfCrongRightPage));
        candidateNumbersOfCrongMaxScore.add(getMultipliedPageDigits(StringOfCrongRightPage));

        int crongScore = getMaxNumberOfList(candidateNumbersOfCrongMaxScore);

        if (pobiScore > crongScore) {
            return ResultType.POBI_WIN.getResult();
        }

        if (crongScore > pobiScore) {
            return ResultType.CRONG_WIN.getResult();
        }
        return ResultType.DRAW.getResult();
    }

    /**
     * 결과로 -1 예외사항이 생길 수 있는지 체크하는 메서드
     */
    public static boolean isImpossiblePages(List<Integer> pages) {
        if (pages.get(RIGHT_INDEX_IN_LIST) - pages.get(LEFT_INDEX_IN_LIST) == 1) {
            return false;
        }
        return true;
    }

    /**
     * int 자료형을 String 자료형으로 변환
     */
    private static String convertIntToString(int number) {
        return String.valueOf(number);
    }

    /**
     * String 자료형의 각 자리를 더한 값을 자료형으로 반환하는 메서드
     */
    private static int getSumPageDigits(String page) {
        int sum = 0;

        for (int i = 0; i < page.length(); i++) {
            char aChar = page.charAt(i);
            int digit = Character.getNumericValue(aChar);
            sum += digit;
        }
        return sum;
    }

    /**
     * String 자료형의 각 자리를 곱한 값을 반환하는 메서드
     */
    private static int getMultipliedPageDigits(String page) {
        int multipliedNumber = 1;

        for (int i = 0; i < page.length(); i++) {
            char aChar = page.charAt(i);
            int digit = Character.getNumericValue(aChar);
            multipliedNumber *= digit;
        }
        return multipliedNumber;
    }

    /**
     * Set 구현체 중 가장 큰 값을 반환
     */
    private static int getMaxNumberOfList(Set<Integer> numbers) {
        return Collections.max(numbers);
    }

    /**
     * 주어진 result 를 반환하기 위한 열거형 클래스
     */
    enum ResultType {
        POBI_WIN(1),
        CRONG_WIN(2),
        DRAW(0),
        EXCEPTION(-1);

        private final int result;

        ResultType(int result) {
            this.result = result;
        }

        public int getResult() {
            return result;
        }
    }
}