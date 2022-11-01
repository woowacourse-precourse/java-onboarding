package onboarding;

import java.util.List;

/**
 * 문제 풀이 방식 & 기능 목록서는
 * docs/PROBLEM1.md 의 하단에 기술되어 있습니다
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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