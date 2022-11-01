package onboarding;

import java.util.List;
import java.util.*;

class Problem1 {

    static int sum(int k) {
        int a = 0;
        String n = Integer.toString(k);
        for (int i = 0; i < n.length(); i++) {
            a += n.charAt(i) - '0';
        }
        return a;
    }

    static int mul(int k) {
        int a = 1;
        String n = Integer.toString(k);
        for (int i = 0; i < n.length(); i++) {
            a *= n.charAt(i) - '0';
        }
        return a;

    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (pobi.get(0) == 0 || pobi.get(1) == 400 || crong.get(0) == 0 || crong.get(1) == 400)
            return 1;
        int checkpobi = pobi.get(1) - pobi.get(0);
        int checkcrong = crong.get(1) - crong.get(0);
        if (checkpobi != 1 || checkcrong != 1)
            return -1;

        int checkmul;
        int checksum;
        int tmp1 = crong.get(0);
        int tmp2 = crong.get(1);
        checkmul = Math.max(mul(tmp1), mul(tmp2));
        checksum = Math.max(sum(tmp1), sum(tmp2));
        checkcrong = Math.max(checkmul, checksum);

        tmp1 = pobi.get(0);
        tmp2 = pobi.get(1);
        checkmul = Math.max(mul(tmp1), mul(tmp2));
        checksum = Math.max(sum(tmp1), sum(tmp2));
        checkpobi = Math.max(checkmul, checksum);

        if (checkpobi == checkcrong)
            answer = 0;
        else if (checkpobi > checkcrong)
            answer = 1;
        else
            answer = 2;
        return answer;
    }
}