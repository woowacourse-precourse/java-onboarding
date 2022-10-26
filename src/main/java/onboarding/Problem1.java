package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static Boolean isPageRangeInBook(int leftPage, int rightPage) {
        if(leftPage<1||leftPage>400){
            return false;
        }
        if(rightPage<1||rightPage>400){
            return false;
        }
        return true;
    }
}
