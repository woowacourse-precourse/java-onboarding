package onboarding;

import java.util.*;
import java.util.List;


class Problem1 {
    public static int numberN(int n){
        int plus = 0;
        int multiple = 1;

        while (n != 0) {
            int temp = n % 10;

            plus += temp;
            multiple *= temp;

            n /= 10;
        }
        return Math.max(plus, multiple);
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max = Integer.MIN_VALUE;
        int crong_max = Integer.MIN_VALUE;

        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1))
            return -1;

        for (int size = 0; size < 2; size++) {
            int p = pobi.get(size);
            int c = crong.get(size);

            pobi_max=numberN(p);
            crong_max=numberN(c);
        }

        if (pobi_max > crong_max) answer = 1;
        else if (pobi_max < crong_max) answer = 2;
        else answer = 0;

        return answer;
    }
}