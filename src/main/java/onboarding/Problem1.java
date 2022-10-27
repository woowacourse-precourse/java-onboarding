package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public int make_score(int page_num){
        int sum = 0;
        int mul = 1;
        for(; page_num > 0; page_num /= 10){
            int num = page_num % 10;
            sum += num;
            mul *= num;
        }
        if (sum > mul){
            return sum;
        }
        else{
            return mul;
        }
    }
}