package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int toScore(int pageNum){
        int sum = 0;
        int mul = 1;

        int num = pageNum;
        for(; num > 0; num /= 10){
            int digit = num % 10;
            sum += digit;
            mul *= digit;
        }
        if (sum > mul){
            return sum;
        }
        else{
            return mul;
        }
    }
}