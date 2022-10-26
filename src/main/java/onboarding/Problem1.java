package onboarding;

import java.util.Arrays;
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

        int pobiMaxNumber = getMaxNumberCalculate(pobi);
        int crongMaxNumber = getMaxNumberCalculate(crong);

        if (pobiMaxNumber > crongMaxNumber) {
            return WIN_POBI;
        }

        if (pobiMaxNumber < crongMaxNumber) {
            return WIN_CRONG;
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
     * 2개의 페이지 값 중 큰 수 가져오기
     * @param pages 페이지 정보
     * @return 결과값
     */
    private static int getMaxNumberCalculate(List<Integer> pages) {
        int returnNumber = 0;

        for(int number: pages) {
            // 각 자리 숫자 더하고 곱해서 제일 큰 수 가져오기
            int[] splitDigits = splitNumber(number);
            int calculateNumber = Integer.max(addAllDigits(splitDigits), multiplyAllDigits(splitDigits));

            if (returnNumber < calculateNumber) {
                returnNumber = calculateNumber;
            }
        }

        return returnNumber;
    }

    /**
     * 각 자리 숫자 더하기
     * @param splitDigits 분할된 숫자 배열
     * @return 결과값
     */
    private static int addAllDigits(int[] splitDigits) {
        int returnNumber = 0;

        for (int i: splitDigits) {
            returnNumber += i;
        }

        return returnNumber;
    }

    /**
     * 각 자리 숫자 곱하기
     * @param splitDigits 분리된 숫자 배열
     * @return 결과값
     */
    private static int multiplyAllDigits(int[] splitDigits) {
        int returnNumber = 1;

        for (int i: splitDigits) {
            returnNumber *= i;
        }

        return returnNumber;
    }

    /**
     * 숫자 분할하기
     * @param number 페이지 숫자
     * @return 분리된 숫자 배열
     */
    private static int[] splitNumber(int number) {
        String stringNumber = String.valueOf(number);
        int lengthStringNumber = stringNumber.length();
        int[] intArrayNumber = new int[lengthStringNumber];

        for (int i = 0; i < lengthStringNumber; i++) {
            intArrayNumber[i] = Integer.parseInt(stringNumber, i, i + 1, 10);
        }

        return intArrayNumber;
    }
}