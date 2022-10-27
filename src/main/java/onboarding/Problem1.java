package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isProblem(pobi) || isProblem(crong)) answer = -1;
        return answer;
    }

    public static boolean isProblem(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        if(rightPage - leftPage != 1) return true;
        if(leftPage % 2 == 0 || rightPage % 2 == 1) return true;
        return false;
    }
}