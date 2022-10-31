package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;


    }

    public static int calculate(int n) {
        int sum = 0;
        int mul = 1;
        while (n != 0) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }
        return Math.max(sum, mul);
    }

}
