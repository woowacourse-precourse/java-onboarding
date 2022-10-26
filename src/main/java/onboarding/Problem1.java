package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static int pobiWin = 1;
    private static int crongWin = 2;
    private static int draw = 0;
    private static int exception = -1;
    private static List<Integer> startPage = List.of(1,2);
    private static List<Integer> endPage = List.of(399,400);

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

    public static boolean validatePageNumbers(List<List<Integer>> pageNumbersInstances){
        for (List<Integer> pageNumbers : pageNumbersInstances){ //for문 내부 함수를 밖으로 빼보자
            int leftPageNumber = pageNumbers.get(0);
            int rightPageNumber = pageNumbers.get(1);
            if (pageNumbers.equals(startPage) || pageNumbers.equals(endPage)){
                return true;
            }
            if (leftPageNumber + 1 != rightPageNumber){
                return true;
            }
            if ((leftPageNumber % 2) == 0 || (rightPageNumber % 2) != 0){
                return true;
            }
        }
        return false;
    }
}