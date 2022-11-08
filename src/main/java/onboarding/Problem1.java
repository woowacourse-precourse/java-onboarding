package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static onboarding.problem1.Calculation.*;
import static onboarding.problem1.Validation.isValidPage;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidPage(pobi) || !isValidPage(crong)) {
            return -1;
        }

        Map<String, Integer> pobiPage = new HashMap<>();
        Map<String, Integer> crongPage = new HashMap<>();

        putData(pobi, pobiPage);
        putData(crong, crongPage);

        return getAnswer(
                Collections.max(pobiPage.values()),
                Collections.max(crongPage.values())
        );
    }

    private static void putData(List<Integer> pageList, Map<String, Integer> pageMap) {
        pageMap.put("left", calculate(pageList.get(0)));
        pageMap.put("right", calculate(pageList.get(1)));
    }

    private static Integer getAnswer(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return 1;
        }

        if (pobiResult < crongResult) {
            return 2;
        }

        return 0;
    }
}