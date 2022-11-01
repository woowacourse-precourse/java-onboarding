package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pageChecks = 0;
        pageChecks += pobi.get(1) - pobi.get(0);
        pageChecks += crong.get(1) - crong.get(0);

        if (pageChecks != 2) {
            return -1;
        }

        return 0;
    }
}