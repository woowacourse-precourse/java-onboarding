package onboarding.problem1.serivce;

import onboarding.problem1.infra.PageNumberAndSizeValidation;
import onboarding.problem1.type.ResultValue;
import onboarding.problem1.type.ValidationValue;

import java.util.Arrays;
import java.util.List;

public class PageService {

    /**
     * @param woowahanTeachers
     * @param validation
     *  1. 파라미터 들어온 인자를 순회하여
     *  2. 왼쪽 오른쪽 페이지 번호로 각 자리 숫자의 합 중 큰 값을 구한다.
     *  3. 왼쪽 오른쪽 페이지 번호로 각 자리 숫자의 곱 중 큰 값을 구한다.
     *  4. 2번 3번의 값을 비교하여 큰 값을 return 한다.
     *  @return Math.max(2번, 3번)
     * @throws IllegalArgumentException
     * */
    public int findMaxValue(List<Integer> woowahanTeachers, PageNumberAndSizeValidation validation) throws IllegalArgumentException {
        Integer leftPageNumber = woowahanTeachers.get(ValidationValue.LEFT_INDEX.getValue());
        Integer rightPageNumber = woowahanTeachers.get(ValidationValue.RIGHT_INDEX.getValue());

        validation.checkedPageNumber(leftPageNumber, rightPageNumber);

        // 왼쪽과 오른쪽 페이지의 각 자리 숫자의 합 중에 큰 값
        int sumMaxValue = getSumMaxValue(leftPageNumber, rightPageNumber);

        // 왼쪽과 오른쪽 페이지의 각 자리 숫자의 곱 중에 제일 큰 값
        int multiplicationMaxValue = getMultiplicationMaxValue(leftPageNumber, rightPageNumber);

        return Math.max(sumMaxValue, multiplicationMaxValue);
    }

    protected int getSumMaxValue(Integer leftPageNumber, Integer rightPageNumber) {
        int leftSumValue = getSumValue(leftPageNumber);
        int rightSumValue = getSumValue(rightPageNumber);

        return Math.max(leftSumValue, rightSumValue);
    }

    protected int getSumValue(Integer pageNumber) {
        String[] pageNumberStringSplit = String.valueOf(pageNumber).split("");
        return Arrays.stream(pageNumberStringSplit)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    protected int getMultiplicationMaxValue(Integer leftPageNumber, Integer rightPageNumber) {
        int leftValue = getMultiplicationValue(leftPageNumber);
        int rightValue = getMultiplicationValue(rightPageNumber);

        return Math.max(leftValue, rightValue);
    }

    protected int getMultiplicationValue(Integer pageNumber) throws NumberFormatException {
        String[] PageNumberStringSplit = String.valueOf(pageNumber).split("");
        int result = 1;

        for (String data : PageNumberStringSplit) {
            try {
                result *= Integer.parseInt(data);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return ResultValue.EXCEPTION_VALUE.getValue();
            }
        }

        return result;
    }

    public int getResult(int pobiMaxValue, int crongMaxValue) {
        Integer exceptionValue = ResultValue.EXCEPTION_VALUE.getValue();
        if (pobiMaxValue == exceptionValue || crongMaxValue == exceptionValue) {
            return exceptionValue;
        }

        if (pobiMaxValue > crongMaxValue) {
            return ResultValue.POBI_WIN.getValue();
        }

        if (pobiMaxValue < crongMaxValue) {
            return ResultValue.CRONG_WIN.getValue();
        }

        if (pobiMaxValue == crongMaxValue) {
            return ResultValue.POBI_CRONG_DRAW.getValue();
        }

        return exceptionValue;
    }
}
