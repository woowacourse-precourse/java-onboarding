package onboarding;

import java.util.List;

class Problem1 {
    private static boolean except_case(List<Integer> lst){
        if (lst == null || lst.get(0) == null || lst.get(1) == null){
            return false;
        }

        int elem1 = lst.get(0);
        int elem2 = lst.get(1);

        if (elem1 <= 1 || elem2 >= 400 || elem1%2 == 0 || elem2%2 == 1 || elem2-elem1 != 1){
            return false;
        }

        return true;
    }

    private static int max_int(List<Integer> lst){
        int max = 0;
        for(Integer page:lst){
            int mul = 1;
            int add = 0;

            while(page >= 1){
                mul *= (page % 10);
                add += (page % 10);
                page /= 10;
            }
            max = Math.max(Math.max(mul, add), max);
        }
        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (except_case(pobi) == false || except_case(crong) == false){
            return -1;
        }

        int max_pobi = max_int(pobi);
        int max_crong = max_int(crong);

        if (max_pobi > max_crong){
            return 1;
        }
        else if (max_pobi < max_crong){
            return 2;
        }
        else return 0;
    }
}