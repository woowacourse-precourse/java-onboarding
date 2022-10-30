package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isException(pobi) || isException(crong)) return -1;
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isException(List<Integer> pages){
        if(pages.size() != 2) return true;
        if(pages.get(0) < 1 || pages.get(1) < 1) return true;
        if(pages.get(0) > 400 || pages.get(1) > 400) return true;
        //연속된 페이지 검사
        if(pages.get(0) % 2 == 1 && pages.get(1) % 2 == 0) return true;
        if((pages.get(1) - pages.get(0)) != 1) return true;
        return false;
    }
}