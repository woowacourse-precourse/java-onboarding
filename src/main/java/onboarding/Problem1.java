package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(0) < 1 || pobi.get(1) > 400 || crong.get(0) < 1 || crong.get(1) > 400){
            return -1;
        }
        if(pobi.get(0) + 1 != pobi.get(1) || crong.get(0) +1 != crong.get(1)){
            return -1;
        }

        int answer = 0;
        int pobi_max = 0, crong_max = 0;
        for(Integer i:pobi) {
            int tmp_sum = 0, tmp_mul = 1;
            for (; i > 0; i /= 10) {
                tmp_sum += i % 10;
                tmp_mul *= i % 10;
            }
            if (tmp_sum > pobi_max || tmp_mul > pobi_max) {
                if (tmp_sum > tmp_mul) {
                    pobi_max = tmp_sum;
                } else {
                    pobi_max = tmp_mul;
                }
            }
        }
        for(Integer j:crong) {
            int tmp_sum = 0, tmp_mul = 1;
            for (; j > 0; j /= 10) {
                tmp_sum += j % 10;
                tmp_mul *= j % 10;
            }
            if (tmp_sum > crong_max || tmp_mul > crong_max) {
                if (tmp_sum > tmp_mul) {
                    crong_max = tmp_sum;
                } else {
                    crong_max = tmp_mul;
                }
            }
        }

        if(pobi_max>crong_max){
            answer = 1;
        }
        else if(pobi_max<crong_max) {
            answer = 2;
        }
        return answer;
    }

}
