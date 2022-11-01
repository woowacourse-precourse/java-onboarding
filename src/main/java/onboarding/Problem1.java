package onboarding;

import java.util.List;
import java.util.*;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pmax = 0;
        int cmax = 0;
        int psum, pmuti;
        int csum, cmuti;

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1) ||
                pobi.get(0) >= pobi.get(1) || crong.get(0) >= crong.get(1))
            return -1;
        for (int i = 0; i < 2; i++) {
            if (pobi.get(i) >= 100) {
                psum = (pobi.get(i) / 100) + ((pobi.get(i) % 100) / 10) + (pobi.get(i) % 10);
                pmuti = (pobi.get(i) / 100) * ((pobi.get(i) % 100) / 10) * (pobi.get(i) % 10);
            } else {
                psum = (pobi.get(i) / 10) + (pobi.get(i) % 10);
                pmuti = (pobi.get(i) / 10) * (pobi.get(i) % 10);
            }
            if (psum >= pmuti && psum > pmax)
                pmax = psum;
            else if (pmuti >= psum && pmuti > pmax)
                pmax = pmuti;
        }

        for (int i = 0; i < 2; i++) {
            if (crong.get(i) >= 100) {
                csum = (crong.get(i) / 100) + ((crong.get(i) % 100) / 10) + (crong.get(i) % 10);
                cmuti = (crong.get(i) / 100) * ((crong.get(i) % 100) / 10) * (crong.get(i) % 10);
            }
            else {
                csum = (crong.get(i) / 10) + (crong.get(i) % 10);
                cmuti = (crong.get(i) / 10) * (crong.get(i) % 10);
            }
            if (csum >= cmuti && csum > cmax)
                cmax = csum;
            else if (cmuti >= csum && cmuti > cmax)
                cmax = cmuti;
        }
        if (cmax == pmax)
            return 0;
        else if (cmax > pmax)
            return 2;
        else
            return 1;
    }
    public static void main(String[] args) {
        List<Integer> pobi = List.of(131, 132);
        List<Integer> crong = List.of(211, 212);
        int result;

        result = solution(pobi, crong);
        System.out.println(result);
    }
}