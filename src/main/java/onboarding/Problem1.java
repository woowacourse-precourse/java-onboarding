package onboarding;

import onboarding.problem1.ConditionValue;
import onboarding.problem1.infra.PageNumberAndSizeValidation;

import java.util.Arrays;
import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        PageNumberAndSizeValidation validation = new PageNumberAndSizeValidation();
        validation.settingFixedPageSize(ConditionValue.FIXED_LIST_SIZE.getValue());

        // TODO 요청 데이터 검증 로직 예외 처리 하는 것이 낫다고 봄
        if (!validation.isPageSize(pobi.size(), crong.size())) {
            return ConditionValue.EXCEPTION_VALUE.getValue();
        }

        int pobiMaxValue = findMaxValue(pobi, validation);
        int crongMaxValue = findMaxValue(crong, validation);

        return getResult(pobiMaxValue, crongMaxValue);
    }

    // TODO 비지니스 로직이니 service 코드로 분리
    protected static int findMaxValue(List<Integer> woowahanTeachers, PageNumberAndSizeValidation validation) {
        Integer leftPageNumber = woowahanTeachers.get(ConditionValue.LEFT_INDEX.getValue());
        Integer rightPageNumber = woowahanTeachers.get(ConditionValue.RIGHT_INDEX.getValue());

        validation.settingPageNumber(leftPageNumber, rightPageNumber);
        if (!validation.isPageNumberValidation()) {
            return ConditionValue.EXCEPTION_VALUE.getValue();
        }

        int sumMaxValue = getSumMaxValue(leftPageNumber, rightPageNumber);
        int multiplicationMaxValue = getMultiplicationMaxValue(leftPageNumber, rightPageNumber);

        return Math.max(sumMaxValue, multiplicationMaxValue);
    }

    // TODO 비지니스 로직이니 service 코드로 분리
    protected static int getSumMaxValue(Integer leftPageNumber, Integer rightPageNumber) {
        int leftSumValue = getSumValue(leftPageNumber);
        int rightSumValue = getSumValue(rightPageNumber);

        return Math.max(leftSumValue, rightSumValue);
    }

    protected static int getSumValue(Integer pageNumber) {
        String[] leftPageNumberStringSplit = pageNumberToStringSplitArray(pageNumber);
        return getSum(leftPageNumberStringSplit);
    }

    protected static int getSum(String[] pageNumberStringSplit) {
        return Arrays.stream(pageNumberStringSplit)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    protected static int getMultiplicationMaxValue(Integer leftPageNumber, Integer rightPageNumber) {
        int leftValue = getMultiplicationValue(leftPageNumber);
        int rightValue = getMultiplicationValue(rightPageNumber);

        return Math.max(leftValue, rightValue);
    }

    protected static int getMultiplicationValue(Integer pageNumber) {
        String[] PageNumberStringSplit = pageNumberToStringSplitArray(pageNumber);
        int leftValue = 1;

        for (String data : PageNumberStringSplit) {
            try {
                leftValue *= Integer.parseInt(data);
            } catch (NumberFormatException e) {
                return ConditionValue.EXCEPTION_VALUE.getValue();
            }
        }

        return leftValue;
    }

    protected static String[] pageNumberToStringSplitArray(Integer pageNumber) {
        return String.valueOf(pageNumber).split("");
    }

    protected static int getResult(int pobiMaxValue, int crongMaxValue) {
        Integer exceptionValue = ConditionValue.EXCEPTION_VALUE.getValue();
        if (pobiMaxValue == exceptionValue || crongMaxValue == exceptionValue) {
            return exceptionValue;
        }

        if (pobiMaxValue > crongMaxValue) {
            return ConditionValue.POBI_WIN.getValue();
        }

        if (pobiMaxValue < crongMaxValue) {
            return ConditionValue.CRONG_WIN.getValue();
        }

        if (pobiMaxValue == crongMaxValue) {
            return ConditionValue.POBI_CRONG_DRAW.getValue();
        }

        return exceptionValue;
    }
}