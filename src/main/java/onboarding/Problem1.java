package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = calculateMaxValue(pobi);
        int crongMax = calculateMaxValue(crong);
        int answer = compareMaxValue(pobiMax, crongMax);
        return answer;
    }

    public static int calculateMaxValue(List<Integer> pageList) {
        List<Integer> resultList = new ArrayList<>();
        for (int num : pageList) {
            resultList.add(sumEveryDigits(num));
            resultList.add(multipleEveryDigits(num));
        }
        int result = Collections.max(resultList);
        return result;
    }
}