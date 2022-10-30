package onboarding;

import java.util.List;

import static java.lang.Math.max;
import static onboarding.problem1.Calculation.*;
import static onboarding.problem1.Validation.isValidPage;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (!isValidPage(pobi) || !isValidPage(crong)) {
            return -1;
        }

        List<Integer> pobiLeftPageDigits = splitDigits(pobi.get(0));
        List<Integer> pobiRightPageDigits = splitDigits(pobi.get(1));

        List<Integer> crongLeftPageDigits = splitDigits(crong.get(0));
        List<Integer> crongRightPageDigits = splitDigits(crong.get(1));

        int pobiLeftResult = max(add(pobiLeftPageDigits), multiplication(pobiLeftPageDigits));
        int pobiRightResult = max(add(pobiRightPageDigits), multiplication(pobiRightPageDigits));

        int crongLeftResult = max(add(crongLeftPageDigits), multiplication(crongLeftPageDigits));
        int crongRightResult = max(add(crongRightPageDigits), multiplication(crongRightPageDigits));

        int pobiResult = max(pobiLeftResult, pobiRightResult);
        int crongResult = max(crongLeftResult, crongRightResult);

        answer = getAnswer(pobiResult, crongResult);

        return answer;
    }

    public static Integer getAnswer(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return 1;
        }

        if (pobiResult < crongResult) {
            return 2;
        }

        return 0;
    }
}