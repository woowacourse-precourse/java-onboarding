package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = 0;
        if(isPageInvalid(pobi) || isPageInvalid(crong)) return -1;
        if (isPageNotContinuous(pobi) || isPageNotContinuous(crong)) return -1;
        return answer;
    }
    public static boolean isPageInvalid(List<Integer> array) {
        return (array.get(0) < 1) || (array.get(0) > 400) || (array.get(1) < 1) || (array.get(1) > 400);
    }
    public static boolean isPageNotContinuous(List<Integer> array) {
        return array.get(0) != array.get(1) -1;
    }
}