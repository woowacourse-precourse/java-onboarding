package onboarding;

import java.util.List;

class Problem1 {
    static int getSumOfDigits(char[] digits) {
        int sum = 0;
        for (int i : digits) {
            i -= 48;
            sum += i;
        }
        return sum;
    }

    static int getProductOfDigits(char[] digits) {
        int product = 1;
        for (int i : digits) {
            i -= 48;
            product *= i;
        }
        return product;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}