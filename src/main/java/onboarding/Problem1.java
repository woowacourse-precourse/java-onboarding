package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1)-pobi.get(0) != 1 || crong.get(1)-crong.get(0)!=1){
            return -1;
        }

        int pm = Math.max(make_max(pobi.get(0)), make_max(pobi.get(1)));
        int cm= Math.max(make_max(crong.get(0)), make_max(crong.get(1)));

        if (pm>cm) return 1;
        if(cm>pm) return 2;
        return 0;
    }

    public static int make_max(int p) {
        int sumr = 0;
        int mul = 1;

        String ep = String.valueOf(p);
        for (int i = 0; i < ep.length(); i++) {
            int index = ep.charAt(i) - '0';
            sumr += index;
            mul *= index;
        }

        return Math.max(mul, sumr);
    }
}