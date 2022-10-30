package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public boolean findException(List<Integer> arr) {
        int leftPage = arr.get(0);
        int rightPage = arr.get(1);
        if (leftPage % 2 == 1 && rightPage == leftPage + 1) {
            return leftPage > 1 && rightPage < 400;
        } else {
            return false;
        }
    }
}