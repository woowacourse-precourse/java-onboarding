package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 풀이 방식 & 기능 목록서는
 * docs/PROBLEM1.md 의 하단에 기술되어 있습니다
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkException(pobi)) return -1;
        if(checkException(crong)) return -1;

        int pobiScore = getPagesMaxScore(pobi);
        int crongScore = getPagesMaxScore(crong);


        return result(pobiScore, crongScore);
    }

    private static int result(int pobiScore, int crongScore) {
        if(pobiScore > crongScore) return 1;
        else if(pobiScore < crongScore) return 2;
        else return 0;
    }

    static int getPagesMaxScore(List<Integer> pages){
        return Math.max(getPageMaxScore(pages.get(0)),getPageMaxScore(pages.get(1)));
    }
    static int getPageMaxScore(int pageNumber){
        List<Integer> pageNumberList = new ArrayList<>();
        int sum = 0, multiply = 1;
        while(pageNumber != 0){
            sum += pageNumber%10;
            multiply *= pageNumber%10;
            pageNumber /= 10;
        }
        return Math.max(sum,multiply);
    }

    static boolean checkException(List<Integer> pages){
        if(!isPageSizeTwo(pages)) return true;

        if(!isPageContinuous(pages)) return true;

        if(!isPageInRange(pages)) return true;

        return false;
    }

    static boolean isPageSizeTwo(List<Integer> pages){
        return pages.size() == 2;
    }

    static boolean isPageContinuous(List<Integer> pages){
        return (pages.get(1) -pages.get(0)) == 1;
    }

    static boolean isPageInRange(List<Integer> pages){
        return pages.get(0) >= 1 && pages.get(1) <= 400;
    }
}