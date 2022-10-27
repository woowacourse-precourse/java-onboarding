package onboarding;

import java.util.List;

class Problem1 {
    private static final int MIN_PAGE = 1;
    private static final int MAX_PAGE = 400;
    public static int addDigits(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }

    public static int multiplyDigits(int num){
        int product = 1;
        while(num > 0){
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}