package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private boolean isNormal(List<Integer> pages) {
        if(pages.get(0) + pages.get(1) < 2 || pages.get(0) + pages.get(1) > 800) return false;
        if(pages.get(0) - pages.get(1) != -1) return false;
        if(pages.get(0) % 2 != 0) return false;
        return true;
    }
    
}