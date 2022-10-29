package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(validatePage(pobi) && validatePage(crong))) {
            return -1;
        }

        int pobiScore = findMaxValue(pobi);
        int crongScore = findMaxValue(crong);

        if(pobiScore > crongScore){
            return 1;
        }
        if(pobiScore == crongScore){
            return 0;
        }

        return 2;
    }

    static boolean validatePage(List<Integer> values) {
        return validateStartOrLastPage(values) && checkSequenceValidation(values) && checkOddEvenValidation(values);
    }

    static int findMaxValue(List<Integer> values) {
        return Math.max(findSumMaxValue(values), findMulMaxValue(values));
    }

    static int findSumMaxValue(List<Integer> values) {
        int sumResult = 0;
        // 입력 값이 유효한 경우, 모든 자리 합의 경우 짝수 페이지가 무조건 크다.
        String stringValue = values.get(1).toString();
        for (int i = 0; i < stringValue.length(); i++) {
            sumResult += Integer.parseInt(String.valueOf(stringValue.charAt(i)));
        }
        return sumResult;
    }

    static int findMulMaxValue(List<Integer> values) {
        int mulResult = 0;

        for (Integer value : values) {
            int tmp = 1;

            char[] currentPage = value.toString().toCharArray();
            for (char page : currentPage) {
                tmp *= Integer.parseInt(String.valueOf(page));
            }
            mulResult = Math.max(mulResult, tmp);
        }

        return mulResult;
    }

    public static boolean checkOddEvenValidation(List<Integer> values) {
        if (values.get(0) % 2 == 0 && values.get(1) % 2 == 1) {
            return false;
        }

        return true;
    }

    public static boolean checkSequenceValidation(List<Integer> values) {
        if (values.get(0) + 1 != values.get(1)) {
            return false;
        }

        return true;
    }

    public static boolean validateStartOrLastPage(List<Integer> values) {
        if (values.get(0) == 1 || values.get(1) == 400) {
            return false;
        }

        return true;
    }
}