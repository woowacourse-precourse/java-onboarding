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
        if(isPageSizeTwo(pages)) return true;

        return false;
    }

    static boolean isPageSizeTwo(List<Integer> pages){
        return pages.size() == 2;
    }

}