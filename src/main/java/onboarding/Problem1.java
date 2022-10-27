package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = whoIsWin(pobi, crong);
        return answer;
    }

    public static int calculateScore(List<Integer> page) {
        int leftSum = Math.max(multiply(page.get(0)), add(page.get(0)));
        int rightSum = Math.max(multiply(page.get(1)), add(page.get(1)));
        return Math.max(leftSum, rightSum);
    }

    public static int multiply(int page) {
        int sum = 1;
        while(page > 0) {
            sum *= page % 10;
            page /= 10;
        }
        return sum;
    }

    public static int add(int page) {
        int sum = 0;
        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }
}