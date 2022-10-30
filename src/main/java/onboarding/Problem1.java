package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        Boolean isPobiValid = validate(pobi);
        if(!isPobiValid)
            return -1;
        Boolean isCrongValid = validate(crong);
        if(!isCrongValid)
            return -1;

        int pobiNum = getBiggerNum(pobi);
        int crongNum = getBiggerNum(crong);

        return selectWinner(pobiNum, crongNum);
    }

    private static int getBiggerNum(List<Integer> pages) {
        int left = selectBiggerNumber(getRadixSum(pages.get(0)), getRadixMultiply(pages.get(0)));
        int right = selectBiggerNumber(getRadixSum(pages.get(1)),getRadixMultiply(pages.get(1)));
        return selectBiggerPage(left, right);
    }

    private static Boolean validate(List<Integer> pages){
        Integer leftPage = pages.get(0);
        Integer rightPage = pages.get(1);

        // 시작 면 혹은 마지막 면인지 검사
        if(leftPage == 1 || rightPage == 400)
            return Boolean.FALSE;

        // 왼쪽 페이지 홀수 검사
        if(leftPage%2 != 1)
            return Boolean.FALSE;

        // 연속된 페이지인지 검사
        if(leftPage + 1 != rightPage)
            return Boolean.FALSE;

        return Boolean.TRUE;
    }


    private static List<Integer> convertIntToIntList(Integer page){
        List<Integer> radix = new ArrayList<>();

        if (page > 99)
            radix.add(page / 100);

        if(page > 9)
            radix.add(page % 100 / 10);

        radix.add(page % 10);

        return radix;
    }

    private static int getRadixSum(Integer page){
        List<Integer> radix = convertIntToIntList(page);

        return radix.stream().mapToInt(Integer::intValue).sum();
    }

    private static int getRadixMultiply(Integer page){
        List<Integer> radix = convertIntToIntList(page);

        return radix.stream().reduce(1, (a, b) -> a * b);
    }

    private static int selectBiggerNumber(int sum, int mul){
        return sum > mul ? sum : mul;
    }

    private static int selectBiggerPage(int left,int right){
        return left > right ? left : right;
    }

    private static int selectWinner(int pobiNumber,int crongNumber){
        if(pobiNumber > crongNumber)
            return 1;

        if(pobiNumber < crongNumber)
            return 2;

        return 0;
    }
}