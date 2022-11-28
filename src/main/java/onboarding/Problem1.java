package onboarding;

import java.util.List;
import onboarding.problem1.Page;
import onboarding.problem1.PageComparator;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            Page pobiPage = new Page(pobi);
            Page crongPage = new Page(crong);

            int pobiMaxValue = pobiPage.getMaxPageValue();
            int crongMaxValue = crongPage.getMaxPageValue();

            return PageComparator.compare(pobiMaxValue, crongMaxValue);
        } catch (Exception e) {
            System.out.println("Exception - PROBLEM1: " + e.getMessage());
            return -1;
        }
    }
}
