package onboarding;

import java.util.List;

class Problem1 {
    private static final int maxPageNum = 400;
    private static final int minPageNum = 1;
    
    private static final int crongWin = 2;
    private static final int pobiWin = 1;
    private static final int draw = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isExceptionCase(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        if(leftPage > rightPage) return false;
        if(leftPage < minPageNum || leftPage > maxPageNum) return false;
        if(rightPage > maxPageNum) return false;
        if(rightPage - leftPage != 1) return false;
        if(leftPage % 2 != 1) return false;

        return true;
    }

    private static int getMaxNum(Integer num) {
        int sum = 0;
        int mul = 1;

        while (num != 0) {
            sum += num % 10;
            mul *= num % 10;
            num /= 10;
        }

        return Math.max(sum, mul);
    }

    private static int getResult(List<Integer> pobi, List<Integer> crong) {
        int maxPobiNum = Math.max(getMaxNum(pobi.get(0)), getMaxNum(pobi.get(1)));
        int maxCrongNum = Math.max(getMaxNum(crong.get(0)), getMaxNum(crong.get(1)));

        if(maxPobiNum < maxCrongNum) return crongWin;
        if(maxPobiNum == maxCrongNum) return draw;
        return pobiWin;
    }
}