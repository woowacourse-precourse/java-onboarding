package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int add(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

    private static int mul(int n) {
        int sum = 1;
        while (n != 0) {
            sum *= n%10;
            n /= 10;
        }
        return sum;
    }

    private static boolean check(List<Integer> list) {
        if (list.get(0)%2 != 1 || list.get(1)%2 != 0) {
            return false;
        } else if (list.get(0) == 1 || list.get(1) == 400) {
            return false;
        } else if (list.get(0)+1 != list.get(1)) {
            return false;
        } else {
            return true;
        }
    }
}