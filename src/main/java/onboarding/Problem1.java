package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_val = 0, crong_val = 0;
        int plus, mul;
        if (!valid(pobi) || !valid(crong))
            return -1;
        for (Integer p: pobi) {
            plus = 0;
            mul = 1;
            while (p > 0) {
                plus += p % 10;
                mul *= p % 10;
                p /= 10;
            }
            pobi_val = Collections.max(List.of(pobi_val, plus, mul));
        }

        for (Integer c: crong) {
            plus = 0;
            mul = 1;
            while (c > 0) {
                plus += c % 10;
                mul *= c % 10;
                c /= 10;
            }
            crong_val = Collections.max(List.of(crong_val, plus, mul));
        }


        return crong_val == pobi_val ? 0 : crong_val < pobi_val ? 1 : 2;
    }

    public static boolean valid(List<Integer> l) {
        if (l.get(0) <= 1 || l.get(0) >= 400 || l.get(1) <= 1 || l.get(1) >= 400)
            return false;
        if (l.get(1) - l.get(0) != 1)
            return false;
        if (l.get(0) % 2 == 0)
            return false;
        return true;
    }
}