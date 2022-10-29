package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static boolean isClapCase(int oneDigitNum) {
        int[] clapCases = {3, 6, 9};

        for (int clapCase : clapCases) {
            if (oneDigitNum == clapCase) {
                return true;
            }
        }

        return false;
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
