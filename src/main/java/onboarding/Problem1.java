package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int sum_pobi = 0;
        int sum_crong = 0;
        if(pobi[0] + pobi[1] >= pobi[0]*pobi[1]){
            sum_pobi = pobi[0] + pobi[1];
        }
        else{
            sum_pobi = pobi[0]*pobi[1];
        }
        if(crong[0] + crong[1] >= crong[0]*crong[1]){
            sum_crong = crong[0] + crong[1];
        }
        else{
            sum_crong = crong[0]*crong[1];
        }
        int answer = Integer.MAX_VALUE;
        if(sum_pobi > sum_crong){
            answer = 1;
        }
        else if(sum_pobi < sum_crong){
            answer = 2;
        }
        else if(sum_pobi == sum_crong){
            answer = 0;
        }
        else{
            answer = -1;
        }
        return answer;
    }
}