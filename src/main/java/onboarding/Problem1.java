package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1))
            return -1;

        int max_pobi = Math.max(max(pobi.get(0)), max(pobi.get(1)));
        int max_crong = Math.max(max(crong.get(0)), max(crong.get(1)));

        if (max_pobi > max_crong)
            return 1;
        else if (max_pobi < max_crong)
            return 2;
        else
            return 0;
    }
    public static int max(int n){
        int sum=0;
        int mul=1;

        while(n>0){
            sum += n%10;
            mul *= n%10;
            n /= 10;
        }

        return Math.max(sum, mul);
    }
}