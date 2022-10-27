package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validation(pobi) || !validation(crong))
            return -1;
        int pobiScore = Math.max(calculate(pobi.get(0)), calculate(pobi.get(1)));
        int crongScore = Math.max(calculate(crong.get(0)), calculate(crong.get(1)));
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean validation(List<Integer> pages) {
        Integer left = pages.get(0);
        Integer right = pages.get(1);
        // 연속된 값이 아니거나, 짝수, 홀수 순인 경우 false
        if (left + 1 != right || left % 2 == 0)
            return false;
        // 왼쪽이 3 ~ 397인 경우만 true
        return left > 1 && left < 399;
    }

    public static int calculate(Integer num) {
        int add = 0;
        int multiply = 1;
        while (num > 0) {
            int n = num % 10;
            add += n;
            multiply *= n;
            num /= 10;
        }
        return Math.max(add, multiply);
    }
}