package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        return answer;
    }

    private static char[] getEachPageNumbers(int page) {
        String s = Integer.toString(page);
        return s.toCharArray();
    }

    private static int getPageSum(char[] pageNumbers) {
        int result = 0;
        for (char c : pageNumbers) {
            result += c - '0';
        }
        return result;
    }

}
