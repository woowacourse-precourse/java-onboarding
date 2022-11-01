package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int p1 = pobi.get(0), p2 = pobi.get(1);
        int c1 = crong.get(0), c2 = crong.get(1);

        if (isException(p1, p2)) return -1;
        if (isException(c1, c2)) return -1;

        int p = Math.max(getAddedSum(p1, p2), getMultipliedSum(p1, p2));
        int c = Math.max(getAddedSum(c1, c2), getMultipliedSum(c1, c2));

        if ( didCrongWin(p, c) ) return 2;
        if ( didPobiWin(p, c) ) return 1;
        return 0;
    }
    static boolean isException (int n, int m) {
        return m - n != 1;
    }

    static int getAddedSum (int n, int m){
        int sum1 = 0, sum2 = 0;

        while(n > 0 || m > 0){
            sum1 += n % 10;
            sum2 += m % 10;
            n /= 10;
            m /= 10;
        }
        return Math.max(sum1, sum2);
    }

    static int getMultipliedSum (int n, int m){
        int mul1 = 1, mul2 = 1;

        while(n > 0 || m > 0){
            if(isOverZero(n)) mul1 *= n % 10;
            if(isOverZero(m)) mul2 *= m % 10;
            n /= 10;
            m /= 10;
        }
        return Math.max(mul1, mul2);
    }
    static boolean isOverZero (int n) {
        return n > 0;
    }
    static boolean didCrongWin (int n, int m) {
        return m > n;
    }

    static boolean didPobiWin (int n, int m) {
        return n > m;
    }
}