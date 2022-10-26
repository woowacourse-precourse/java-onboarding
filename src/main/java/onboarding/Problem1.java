package onboarding;

import java.util.List;

class Problem1 {
    public static boolean validator(List<Integer> pages) {
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        return leftPage > 0 && leftPage < 400 && rightPage > 1 && rightPage <= 400 && rightPage - leftPage == 1;
    }
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}