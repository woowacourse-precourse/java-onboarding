package onboarding;

import java.util.List;

import onboarding.pagenumbergame.Page;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Page pobiPage = new Page(pobi);
        Page crongPage = new Page(crong);
        return pobiPage.compare(crongPage);
    }
}