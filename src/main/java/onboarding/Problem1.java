package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
    public static int getSumOfNumbers(int num) {
        int sum  = 0;
        int temp = num;
        while (temp != 0) {
            sum += Math.floorMod(temp, 10);
            temp = Math.floorDiv(temp, 10);
        }
        return sum;
    }
    public static int getProductOfNumbers(int num) {
        int sum  = 1;
        int temp = num;
        while (temp != 0) {
            sum *= Math.floorMod(temp, 10);
            temp = Math.floorDiv(temp, 10);
        }
        return sum;
    }
}