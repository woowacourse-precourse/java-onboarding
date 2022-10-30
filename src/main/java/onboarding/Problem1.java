package onboarding;

import java.util.List;

class Problem1 {
    public static int getMultiplyOfDigits(int number) {
        int multiply = 1;
        while(number != 0){
            multiply *= number%10;
            number /= 10;
        }

        return multiply;
    }

    public static int getSumOfDigits(int number) {
        int sum = 0;
        while(number != 0){
            sum += number%10;
            number /= 10;
        }

        return sum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}