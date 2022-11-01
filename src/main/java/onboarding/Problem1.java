package onboarding;

import java.util.List;

class Problem1 {
    static boolean seq(List<Integer> guy) {
        return (guy.get(1) - guy.get(0) == 1);
    }

    static boolean val(List<Integer> guy) {
        return (guy.get(1) % 2 == 0) && (guy.get(0) % 2 == 1);
    }

    static boolean fporlp(List<Integer> guy) {
        return (guy.get(1) == 400) || (guy.get(0) == 1);
    }

    static int mulplu(List<Integer> guy) {
        int mx = 0, resmx = 0;
        int res1, res2;
        for(int a : guy) {
            int tmp = a;
            res1 = 0; res2 = 1;
            while(tmp != 0) {
                res1 += tmp % 10;
                res2 *= tmp % 10;
                tmp /= 10;
            }
            resmx = Math.max(res1, res2);
            mx = Math.max(resmx, mx);
        }
        return mx;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // Validation
        if(pobi.size() != 2 || crong.size() != 2) return -1;
        if(!seq(pobi) || !seq(crong)) return -1;
        if(!val(pobi) || !val(crong)) return -1;
        if(fporlp(pobi) || fporlp(crong)) return -1;
        
        int p = mulplu(pobi);
        int c = mulplu(crong);

        if(p > c) answer = 1;
        else if(p < c) answer = 2;
        else answer = 0;
        return answer;
    }
}