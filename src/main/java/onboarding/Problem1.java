package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static Integer sumDigit (Integer num){
        int sum=0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }


}