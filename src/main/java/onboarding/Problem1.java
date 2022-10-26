package onboarding;

import java.util.List;

class Problem1 {

    private final static int EXCEPTION = -1;
    private final static int DRAW = 0;
    private final static int WIN_POBI = 1;
    private final static int WIN_CRONG = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageNumbers(pobi) || !validatePageNumbers(crong)) {
            return EXCEPTION;
        }



        return DRAW;
    }

    /**
     *
     * @param pages 페이지 정보
     * @return 입력값 검증 유효 여부
     */
    private static boolean validatePageNumbers(List<Integer> pages) {
        // 페이지 숫자가 2개인지 검증
        if (pages.size() != 2) {
            return false;
        }

        for(int page : pages) {
            // 페이지 값이 1 ~ 400 사이인지 확인
            if (page <= 1 || page >= 400) {
                return false;
            }
        }

        // 페이지 값이 오른쪽이 왼쪽보다 1만큼 큰지 확인
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }

        return true;
    }

    /**
     * 입력된 수를 각각 더하고 곱해서 큰 값 가져오기
     * @param pages 페이지 정보
     * @return 결과값
     */
    private static int getMaxNumberCalculate(List<Integer> pages) {
        int returnNumber = 0;

        for(int number: pages) {
            // 각 자리 숫자 더하고 곱해서 제일 큰 수 가져오기
            int calculateNumber = Integer.max(addAllDigits(number), multiplyAllDigits(number));

            if (returnNumber < calculateNumber) {
                returnNumber = calculateNumber;
            }
        }

        return returnNumber;
    }

    /**
     * 각 자리 숫자 더하기
     * @param number 페이지 숫자
     * @return 결과값
     */
    private static int addAllDigits(int number) {
        int[] splitDigits = splitDigits(number);

        int returnNumber = 0;

        for (int i: splitDigits) {
            returnNumber += i;
        }

        return returnNumber;
    }

    /**
     * 각 자리 숫자 곱하기
     * @param number 페이지 숫자
     * @return 결과값
     */
    private static int multiplyAllDigits(int number) {
        int[] splitDigits = splitDigits(number);
        int returnNumber = 1;

        for (int i: splitDigits) {
            returnNumber *= i;
        }

        return returnNumber;
    }

    /**
     * 숫자 분할하기
     * @param number 페이지 숫자
     * @return 분할된 숫자 배열
     */
    private static int[] splitDigits(int number) {
        char[] charsNumber = String.valueOf(number).toCharArray();
        int lengthCharNumber = charsNumber.length;
        int[] intArrayNumber = new int[lengthCharNumber];

        for (int i = 0; i < lengthCharNumber; i++) {
            intArrayNumber[i] = charsNumber[i];
        }

        return intArrayNumber;
    }






}