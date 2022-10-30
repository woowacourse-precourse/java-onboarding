package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = calculateMaxValue(pobi);
        int crongMax = calculateMaxValue(crong);
        int answer = compareMaxValue(pobiMax, crongMax);
        return answer;
    }
}