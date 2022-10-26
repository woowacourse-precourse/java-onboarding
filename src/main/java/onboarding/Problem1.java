package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static int findMaxOfMultiAndAdd(int pageNum) {
        int sum = addElements(pageNum);
        int multi = multiElements(pageNum);
        return Math.max(sum, multi);
    }
    public static int addElements(int n) {
        int total = 0;

        while (n > 0) {
            total += n % 10;
            n = n / 10;
        }

        return total;
    }
    public static int multiElements(int n) {
        int total = 1;

        while (n > 0) {
            total *= n % 10;
            n = n / 10;
        }

        return total;
    }
}
