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

    public static int getMax(List<Integer> player){
        int leftSum = addDigits(player.get(0));
        int rightSum = addDigits(player.get(1));
        int leftProduct = multiplyDigits(player.get(0));
        int rightProduct = multiplyDigits(player.get(1));
        int leftMax = compareNumbers(leftSum, leftProduct);
        int rightMax = compareNumbers(rightSum, rightProduct);
        int result = compareNumbers(leftMax, rightMax);
        return result;
    }

    public static int compareNumbers(int num1, int num2){
        int result = 0;
        if(num1 > num2){
            result = num1;
        }
        if(num2 >= num1){
            result = num2;
        }
        return result;
    }

    public static boolean checkValidity(List<Integer> player){
        boolean result = true;
        int num1 = player.get(0);
        int num2 = player.get(1);
        if(num1 < MIN_PAGE || num1 > MAX_PAGE){
            result = false;
        }
        if(num2 < MIN_PAGE || num2 > MAX_PAGE){
            result = false;
        }
        if(num2 - num1 != 1){
            result = false;
        }
        if(num1 % 2 == 1 && num2 % 2 == 0){
            result = false;
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}