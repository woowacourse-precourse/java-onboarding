package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getSum (int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static int getMultiply (int num){
        int multiply = 1;
        while(num != 0){
            multiply *= num%10;
            num /= 10;
        }
        return multiply;
    }
}