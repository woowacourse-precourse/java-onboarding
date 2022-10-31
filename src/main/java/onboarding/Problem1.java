package onboarding;

import java.util.List;

class Problem1 {
    private static int getMaxPageNum(int pageNum) throws IllegalArgumentException {
        if(pageNum > 400 || pageNum < 1)
            throw new IllegalArgumentException();
        int add = 0, mul = 1;
        while(pageNum > 0) {
            add += pageNum % 10;
            mul *= pageNum % 10;
            pageNum = pageNum / 10;
        }
        return Math.max(add, mul);
    }
    private static int getMaxPage(List<Integer> pages) throws IllegalArgumentException {
        if(pages.get(1) - pages.get(0) != 1 || pages.get(0) > pages.get(1))
            throw new IllegalArgumentException();

        return Math.max(
                getMaxPageNum(pages.get(0)), getMaxPageNum(pages.get(1))
        );
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int resultPobi, resultCrong;
        try {
            resultPobi = getMaxPage(pobi);
            resultCrong = getMaxPage(crong);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        if(resultPobi > resultCrong) answer = 1;
        else if(resultPobi < resultCrong) answer = 2;
        else answer = 0;
        return answer;
    }
}