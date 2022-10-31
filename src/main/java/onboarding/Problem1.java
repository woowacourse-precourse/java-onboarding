package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!rulecheck(pobi, crong)) {
            return -1;
        }


        int pobimax = 0;
        int crongmax = 0;
        for (int num : pobi) {

            pobimax = Math.max(calc(num), pobimax);
        }
        for (int num : crong) {
            crongmax = Math.max(calc(num), crongmax);
        }

        if (pobimax > crongmax) {
            return 1;

        } else if (pobimax < crongmax) {
            return 2;
        } else {
            return 0;
        }


    }

    static int calc(int num) {
        String numstr = Integer.toString(num);
        int sum = 0;
        int mult = 1;
        for (int i = 0; i < numstr.length(); i++) {
            sum += (numstr.charAt(i) - '0');
            mult *= (numstr.charAt(i) - '0');
        }
        return Math.max(sum, mult);
    }

    static boolean rulecheck(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0)) != 1 || (crong.get(1) - crong.get(0)) != 1) {//
            return false;
        }
        for (int i = 0; i < 2; i++) {
            if (pobi.get(i) % 2 != (i + 1) % 2 || crong.get(i) % 2 != (i + 1) % 2) {//홀짝
                return false;
            }
        }
        return true;
    }
}
