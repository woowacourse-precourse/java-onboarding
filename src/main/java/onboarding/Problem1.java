package onboarding;

import java.util.List;
import onboarding.problem1.Page;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Page pobiPage = new Page(pobi);
            Page crongPage = new Page(crong);

            int pobiMaxValue = pobiPage.getMaxPageValue();
            int crongMaxValue = crongPage.getMaxPageValue();

            return compare(pobiMaxValue, crongMaxValue);
        } catch (Exception e) {
            System.out.println("Exception - PROBLEM1: " + e.getMessage());
            return -1;
        }
    }

    public static int compare(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        }
        if (value1 < value2) {
            return 2;
        }
        return 0;
    }
}
