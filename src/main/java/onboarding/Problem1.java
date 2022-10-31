package onboarding;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (abs(pobi.get(0) - pobi.get(1)) != 1 || abs(crong.get(0) - crong.get(1)) != 1) {
            return -1;
        }
        int pobiLeftMax = calPage(pobi.get(0).toString());
        int crongLeftMax = calPage(crong.get(0).toString());

        int pobiRightMax = calPage(pobi.get(1).toString());
        int crongRightMax = calPage(crong.get(1).toString());

        int pobiMax = max(pobiLeftMax, pobiRightMax);
        int crongMax = max(crongLeftMax, crongRightMax);

        if (pobiMax < crongMax) {
            return 2;
        }
        else if (pobiMax > crongMax) {
            return 1;
        }
        else {
            return 0;
        }
    }

    private static int calPage(String page) {
        int add = 0, mul = 1;
        for (int i = 0; i < page.length(); i++) {
            add += Character.getNumericValue(page.charAt(i));
            mul *= Character.getNumericValue(page.charAt(i));
        }
        return max(add, mul);
    }

}