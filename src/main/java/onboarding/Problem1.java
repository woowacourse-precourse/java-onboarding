package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isError(pobi, crong)) {
            return -1;
        }
        int pobiMax = 0;
        int crongMax = 0;
        for (int i = 0; i <= 1; i++) {
            pobiMax = Math.max(pobiMax, sum(pobi.get(i)));
            pobiMax = Math.max(pobiMax, mul(pobi.get(i)));
            crongMax = Math.max(crongMax, sum(crong.get(i)));
            crongMax = Math.max(crongMax, mul(crong.get(i)));
        }
        if (pobiMax > crongMax) {
            return 1;
        } else if (pobiMax < crongMax) {
            return 2;
        } else {
            return 0;
        }
    }
    public static boolean isError(List<Integer> pobi, List<Integer> crong) {
        for (int i = 0; i <= 1; i++) {
            if (!(0 < pobi.get(i) && pobi.get(i) <= 400)) {
                return true;
            }
            if (!(0 < crong.get(i) && crong.get(i) <= 400)) {
                return true;
            }
        }
        if (!((pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1)))) {
            return true;
        }
        if (!((pobi.get(1) % 2 == 0) && (crong.get(1) % 2 == 0))) {
            return true;
        }
        return false;
    }
    public static int sum(int n) {
        int ret = 0;
        while (n > 0) {
            ret += n % 10;
            n /= 10;
        }
        return ret;
    }
    public static int mul(int n) {
        int ret = 1;
        while (n > 0) {
            ret *= n % 10;
            n /= 10;
        }
        return ret;
    }
}