package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static boolean confirm(List<Integer> page) {
        if (page.get(1) - page.get(0) == 1 && page.get(0) % 2 != 0 && page.get(1) % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static int max(List<Integer> page) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < page.size(); i++) {
            List<Integer> list = new ArrayList<>();
            int p = page.get(i);
            int sum = 0;
            int multi = 1;
            while (p > 0) {
                list.add(p % 10);
                p = p / 10;
            }
            for (int x : list) {
                sum += x;
                multi *= x;
            }
            result.add(i, Math.max(sum, multi));
        }


        return Math.max(result.get(1), result.get(0));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (Problem1.confirm(pobi) || Problem1.confirm(crong)) {
            return -1;

        }
        int pobiScore = Problem1.max(pobi);
        int crongScore = Problem1.max(crong);

        if (pobiScore == crongScore) {
            return 0;
        } else if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return -1;
        }
    }
}