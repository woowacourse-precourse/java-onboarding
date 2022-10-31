package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {


    }


    public static int Maxnum(int num) {
        int sum = 0, mul = 1;
        while(num != 0) {
            sum += num % 10;
            mul *= num % 10;
            num /= 10;
        }
        return Math.max(sum, mul);
    }
}