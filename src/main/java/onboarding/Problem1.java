package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int pobiWin = 1;
    private static final int crongWin = 2;
    private static final int draw = 0;
    private static final int exception = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(validatePageNumbers(List.of(pobi, crong))){
            return exception;
        }// 이제 pobi, crong을 신뢰할 수 있다.

        int pobiMaxValue = calculateMaxValue(pobi);
        int crongMaxValue = calculateMaxValue(crong);

        if (pobiMaxValue < crongMaxValue){
            return crongWin;
        }
        if (crongMaxValue < pobiMaxValue){
            return pobiWin;
        }
        return draw;
    }

    public static int calculateMaxValue(List<Integer> pageNumbers){
        int sumResult = sum(pageNumbers);
        int multiplyResult = multiply(pageNumbers);

        if (sumResult <= multiplyResult){
            return multiplyResult;
        }
        return sumResult;
    }

    public static int sum(List<Integer> pageNumbers){
        int maxSumValue = 0;
        for (int i =0; i<2; i++){
            int pageNumber = pageNumbers.get(i);
            int digit;
            int sumValue = 0;
            while (pageNumber >0){
                digit = pageNumber % 10;
                pageNumber /= 10;
                sumValue += digit;
            }
            if (maxSumValue <= sumValue){
                maxSumValue = sumValue;
            }
        }
        return maxSumValue;
    }

    public static int multiply(List<Integer> pageNumbers){
        int maxSumValue = 0;
        for (int i =0; i<2; i++){
            int pageNumber = pageNumbers.get(i);
            int digit;
            int multiplyValue = 1;
            while (pageNumber >0){
                digit = pageNumber % 10;
                pageNumber /= 10;
                multiplyValue *= digit;
            }
            if (maxSumValue <= multiplyValue){
                maxSumValue = multiplyValue;
            }
        }
        return maxSumValue;
    }

    public static boolean validatePageNumbers(List<List<Integer>> pageNumbersInstances){
        for (List<Integer> pageNumbers : pageNumbersInstances){
            int leftPageNumber = pageNumbers.get(0);
            int rightPageNumber = pageNumbers.get(1);
            if (leftPageNumber + 1 != rightPageNumber){
                return true;
            }
            if (leftPageNumber < 1 || rightPageNumber > 400){
                return true;
            }
            if ((leftPageNumber % 2) == 0 || (rightPageNumber % 2) != 0){
                return true;
            }
        }
        return false;
    }
}