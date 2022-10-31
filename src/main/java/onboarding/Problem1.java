package onboarding;

import java.util.List;

class Problem1 {
    public static boolean check_exception(List<Integer> li){
        int left = li.get(0); int right = li.get(1);
        if((left&1) == 0 || (right&1) == 1) return true;
        if(left + 1 != right) return true;
        if(left<1 || left>400) return true;
        if(right<1 || right>400) return true;
        return false;
    }
    public static int op_val(List<Integer> li){
        int left = li.get(0); int right = li.get(1);
        int lmul = 1, lsum = 0;
        while(left>0) {
            lmul *= left%10;
            lsum += left%10;
            left /= 10;
        }
        int lval = Math.max(lmul,lsum);

        int rmul = 1, rsum = 0;
        while(right>0){
            rmul *= right%10;
            rsum += right%10;
            right /= 10;
        }
        int rval = Math.max(rmul,rsum);

        return Math.max(lval,rval);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(check_exception(pobi) || check_exception(crong)) return -1;
        int p = op_val(pobi); int c = op_val(crong);
        if(p>c) return 1;
        else if(p<c) return 2;
        else return 0;
    }
}