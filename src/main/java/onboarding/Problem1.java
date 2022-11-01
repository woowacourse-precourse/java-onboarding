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

        int pobiLeftPage = pobi.get(LEFT_INDEX_IN_LIST);
        String pobiLeftPageText = convertIntToString(pobiLeftPage);
        candidateNumbersOfPobiMaxScore.add(getSumDigits(pobiLeftPageText));
        candidateNumbersOfPobiMaxScore.add(getMultipliedDigits(pobiLeftPageText));

        int pobiRightPage = pobi.get(RIGHT_INDEX_IN_LIST);
        String pobiRightPageText = convertIntToString(pobiRightPage);
        candidateNumbersOfPobiMaxScore.add(getSumDigits(pobiRightPageText));
        candidateNumbersOfPobiMaxScore.add(getMultipliedDigits(pobiRightPageText));

        int pobiScore = getMaxNumberOfList(candidateNumbersOfPobiMaxScore);

        Set<Integer> candidateNumbersOfCrongMaxScore = new HashSet<>(NUMBER_OF_CANDIDATES_FOR_SCORE);

        int crongLeftPage = crong.get(LEFT_INDEX_IN_LIST);
        String crongLeftPageText = convertIntToString(crongLeftPage);
        candidateNumbersOfCrongMaxScore.add(getSumDigits(crongLeftPageText));
        candidateNumbersOfCrongMaxScore.add(getMultipliedDigits(crongLeftPageText));

        int crongRightPage = crong.get(RIGHT_INDEX_IN_LIST);
        String crongRightPageText = convertIntToString(crongRightPage);
        candidateNumbersOfCrongMaxScore.add(getSumDigits(crongRightPageText));
        candidateNumbersOfCrongMaxScore.add(getMultipliedDigits(crongRightPageText));

        if (isEvenNumber(pobiLeftPage) || isEvenNumber(crongLeftPage)) {
            return ResultType.EXCEPTION.result;
        }

        if (isOddNumber(pobiRightPage) || isOddNumber(crongRightPage)) {
            return ResultType.EXCEPTION.result;
        }

        int crongScore = getMaxNumberOfList(candidateNumbersOfCrongMaxScore);

        System.out.println("pobiScore = " + pobiScore);
        System.out.println("crongScore = " + crongScore);

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
    private static int getSumDigits(String page) {
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
    private static int getMultipliedDigits(String page) {
        int multipliedNumber = 1;
        System.out.println("=========================");
        for (int i = 0; i < page.length(); i++) {
            char aChar = page.charAt(i);
            int digit = Character.getNumericValue(aChar);
            System.out.println("digit = " + digit);
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

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    private static boolean isOddNumber(int number) {
        return number % 2 != 0;
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

        /**
         * 열거형 클래스의 각 값을 가지고 오기 위한 메서드
         */
        public int getResult() {
            return result;
        }
    }
}