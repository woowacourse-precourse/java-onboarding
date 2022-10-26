package onboarding;

import java.util.List;

class Problem1 {

    private static int compare(int num1, int num2) {
        int bigNum = 0;

        if (num1 > num2) {
            bigNum = num1;
        } else {
            bigNum = num2;
        }
        return bigNum;
    }

    private static int compareAddAndMul(int num) {
        int add = 0;
        int mul = 1;

        while (num != 0) {
            add += num % 10;
            mul *= num % 10;
            num /= 10;
        }

        return compare(add, mul);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}