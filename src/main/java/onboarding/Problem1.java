package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = scoreEvaluate(getAddMulMax(pobi), getAddMulMax(crong));
        if (!is_Valid(pobi) || !is_Valid(crong))
            answer = -1;
        return answer;
    }
    private static int getAddMulMax(List<Integer> first_list){
        int result = 0;
        int temp_list, temp_add_cal, temp_mul_cal;
        for(int i = 0; i < first_list.size(); i++){
            temp_list = first_list.get(i);
            temp_add_cal = 0;
            temp_mul_cal = 1;
            while(temp_list > 0){
                temp_add_cal += temp_list % 10;
                temp_mul_cal *= temp_list % 10;
                temp_list /= 10;
            }
            result = (temp_add_cal > temp_mul_cal) ? temp_add_cal : temp_mul_cal;
        }
        return result;
    }
    private static int scoreEvaluate(int first_num, int second_num){
        int result = 0;
        result = (first_num > second_num) ? 1 : 2;
        result = (first_num == second_num) ? 0 : result;
        return result;
    }
    private static boolean is_Valid(List<Integer> first_list){
        boolean result = true;
        if(first_list.get(0) % 2 == 0 || first_list.get(1) % 2 == 1)
            result = false;
        if(first_list.get(1) - first_list.get(0) != 1 || first_list.get(0) <= 1 || first_list.get(1) >= 400)
            result = false;
        return result;
    }
}