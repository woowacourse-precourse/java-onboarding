package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_value, crong_value;
        Integer pobi_left = pobi.get(0);
        Integer pobi_right = pobi.get(1);
        Integer crong_left = crong.get(0);
        Integer crong_right = crong.get(1);

        if(pobi_right - pobi_left != 1 || crong_right - crong_left != 1) return -1;
        if(pobi_left < 1 || pobi_right > 400 || crong_left < 0 || crong_right > 400) return -1;
        if(pobi_left == 1 || crong_left == 1 || pobi_right == 400 || crong_right == 400) return -1;
        int pobi_left_sol = sub_solution(pobi_left);
        int pobi_right_sol = sub_solution(pobi_right);
        int crong_left_sol = sub_solution(crong_left);
        int crong_right_sol = sub_solution(crong_right);

        if(pobi_left_sol >= pobi_right_sol) pobi_value = pobi_left_sol;
        else pobi_value = pobi_right_sol;
        if(crong_left_sol >= crong_right_sol) crong_value = crong_left_sol;
        else crong_value = crong_right_sol;

        if(pobi_value > crong_value) return 1;
        else if (pobi_value == crong_value) return 0;
        else return -2;
    }

    public static int sub_solution(int input){
        int tmp_add = 0;
        int tmp_multi = 1;
        while(input > 0){
            int cur = input % 10;
            tmp_add += cur;
            tmp_multi *= cur;
            input = input / 10;
        }
        if(tmp_add >= tmp_multi) return tmp_add;
        else return tmp_multi;
    }
}