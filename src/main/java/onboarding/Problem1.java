package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score = getAddMulMax(pobi);
        int crong_score = getAddMulMax(crong);
        int pobi_test = pobi.get(1) - pobi.get(0);
        int crong_test = crong.get(1) - crong.get(0);
        answer = (pobi_score > crong_score) ? 1 : 2;
        answer = (pobi_score == crong_score) ? 0 : answer;
        if (pobi_test != 1 || crong_test != 1)
            answer = -1;
        return answer;
    }
    public static int getAddMulMax(List<Integer> input){
        int result = 0;
        int temp_list, temp_add_cal, temp_mul_cal;
        for(int i = 0; i < input.size(); i++){
            temp_list = input.get(i);
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
}
