package onboarding;

import java.util.*;
import java.util.stream.Stream;

class Problem1 {
    /**
     * 페이지가 유효하지 않을 때 발생하는 예외
     */
    static class PageValidationException extends RuntimeException {
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            // 페이지가 유효하지 않을 때 예외 발생
            if (!checkPageValidation(pobi) || !checkPageValidation(crong)) {
                throw new PageValidationException();
            }

            int pobiResult = getResult(pobi);
            int crongResult = getResult(crong);

            // 점수 비교
            if (pobiResult > crongResult) {
                return 1;
            } else if (crongResult > pobiResult) {
                return 2;
            } else if (pobiResult == crongResult) {
                return 0;
            } else {
                return -1;
            }
        } catch (PageValidationException e) {
            return -1;
        }
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
     * 배열 내 숫자의 합을 구한다.
     * @param numbers 분리된 숫자의 배열
     * @return 배열 내 숫자의 총합
     */
    private static int sumNumbers(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    /**
     * 배열 내 숫자의 곱을 구한다.
     * @param numbers 분리된 숫자의 배열
     * @return 배열 내 숫자의 곱
     */
    private static int multiplyNumbers(int[] numbers) {
        return Arrays.stream(numbers).reduce(1, (a, b) -> a * b);
    }

    /**
     * 문제의 결과를 계산한다.
     * @param inputList 입력된 페이지 숫자 리스트
     * @return 점수
     */
    private static int getResult(List<Integer> inputList) {
        ArrayList<Integer> resultList = new ArrayList<>();

        for (Integer e : inputList) {
            int[] splittedArray = splitEachNumbers(e);
            int sumResult = sumNumbers(splittedArray);
            int multiplyResult = multiplyNumbers(splittedArray);
            int result = Math.max(sumResult, multiplyResult);
            resultList.add(result);
        }
        return Collections.max(resultList);
    }

    /**
     * 페이지 숫자를 검증한다.
     * @param inputList 입력된 페이지 숫자 리스트
     * @return 참 거짓
     */
    private static Boolean checkPageValidation(List<Integer> inputList) {
        int firstPage = inputList.get(0);
        int secondPage = inputList.get(1);

        if (secondPage == firstPage + 1) {
            return true;
        }
        return false;
    }
}