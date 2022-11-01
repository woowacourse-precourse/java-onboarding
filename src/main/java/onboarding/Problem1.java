package onboarding;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1 {

    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int result = Problem1.solution(pobi, crong);
        System.out.println(result);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_result = 0;
        int crong_result = 0;

        if(pobi.get(0) <= 0 || crong.get(0) <= 0){
            answer =  -1;
        }
        else if(pobi.get(0) >= pobi.get(1) || crong.get(0) >= crong.get(1)){
            answer =  -1;
        }
        else if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            answer =  -1;
        }
        else{
            pobi_result = pobi.get(0) + pobi.get(1);
            crong_result = crong.get(0) + crong.get(1);
            if(pobi.get(0) * pobi.get(1) >= pobi_result){
                pobi_result = pobi.get(0) * pobi.get(1);
            }
            if(crong.get(0) * crong.get(1) >= crong_result){
                crong_result = crong.get(0) * crong.get(1);
            }
        }

        if (pobi_result > crong_result) {
            answer = 1;
        }
        else if (pobi_result < crong_result) {
            answer = 2;
        }
        else if (pobi_result == crong_result) {
            answer = 0;
        }
        return answer;
    }
}