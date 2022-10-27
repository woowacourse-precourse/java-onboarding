package onboarding;

import java.util.List;

class Problem1 {
    public static int bignum(int page) {
        int sum = 0, mux = 1, tmp;
        while(page > 0) {
            tmp = page % 10;
            sum += tmp;
            mux *= tmp;
        }
        return sum > mux? sum : mux;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int ponum = Math.max(bignum(pobi.get(0)), bignum(pobi.get(1))), crnum = Math.max(bignum(pobi.get(0)), bignum(pobi.get(1)));
        if(ponum > crnum) return 1;
        if(crnum > ponum) return 2;
        if(crnum == ponum) return 0;
        return -1;
    }
}