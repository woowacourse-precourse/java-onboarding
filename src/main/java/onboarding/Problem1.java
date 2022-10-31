package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) return -1;
        int pl_max = cal_mul(pobi.get(0)) > cal_sum(pobi.get(0)) ? cal_mul(pobi.get(0)) : cal_sum(pobi.get(0));
        int pr_max = cal_mul(pobi.get(1)) > cal_sum(pobi.get(1)) ? cal_mul(pobi.get(1)) : cal_sum(pobi.get(1));
        int p_max = pl_max > pr_max ? pl_max : pr_max;

        int cl_max = cal_mul(crong.get(0)) > cal_sum(crong.get(0)) ? cal_mul(crong.get(0)) : cal_sum(crong.get(0));
        int cr_max = cal_mul(crong.get(1)) > cal_sum(crong.get(1)) ? cal_mul(crong.get(1)) : cal_sum(crong.get(1));;
        int c_max = cl_max > cr_max ? cl_max : cr_max;

        if (p_max == c_max) return 0;
        else if (p_max>c_max) return 1;
        else return 2;

    }

    public static int cal_mul(int i){
        int result = 1;
        while (i>0) {
            result *= i%10;
            i/=10;
        }
        return result;
    }

    public static int cal_sum(int i){
        int result = 0;
        while (i>0) {
            result += i%10;
            i/=10;
        }
        return result;
    }
}