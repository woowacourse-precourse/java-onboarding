package onboarding;

import java.util.List;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private List<Integer> divideNumberByDigit (int pageNumber) {
        List<Integer> result = new ArrayList();
        for (int i = pageNumber; i > 0; i /= 10) {
            result.add(i % 10);
        }
        return result;
    }
}