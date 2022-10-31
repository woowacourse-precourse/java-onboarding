package onboarding;

import java.util.List;

class Problem1 {
    public static int getBigNumberOf(int page) {
        int sum = 0, mux = 1, tmp;
        while(page > 0) {
            tmp = page % 10;
            sum += tmp;
            mux *= tmp;
            page /= 10;
        }
        return Math.max(sum, mux);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if((pobi.get(0)&1) != 1 || (crong.get(0)&1) != 1 || (pobi.get(1)&1) != 0 || (crong.get(1)&1) != 0 ||
                pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) return -1;
        int pobiNumber = Math.max(getBigNumberOf(pobi.get(0)), getBigNumberOf(pobi.get(1)));
        int crongNumber = Math.max(getBigNumberOf(crong.get(0)), getBigNumberOf(crong.get(1)));
        if(pobiNumber > crongNumber) return 1;
        if(crongNumber > pobiNumber) return 2;
        return 0;
    }
}