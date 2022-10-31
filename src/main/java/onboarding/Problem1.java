package onboarding;

import onboarding.problem1.Page;
import onboarding.problem1.PageValidator;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!PageValidator.isValidatePage(pobi, crong)) {
            return -1;
        }
        final Page pobiPage = Page.create(pobi);
        final Page crongPage = Page.create(crong);

        return pobiPage.compareTo(crongPage);
    }
}
