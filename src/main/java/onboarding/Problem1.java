package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int addNumber(int num){
        int result = 0;
        while(num != 0){
            result += (num % 10);
            num /= 10;
        }
        return result;
    }
}