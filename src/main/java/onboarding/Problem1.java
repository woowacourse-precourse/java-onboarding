package onboarding;

import java.util.List;

class Problem1 {
    public static int findWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (crongScore < pobiScore) {
            return -1;
        }
        return 0;
    }

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