package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = Math.max(findMaxNum(pobi.get(0)), findMaxNum(pobi.get(1)));
        int crongMax = Math.max(findMaxNum(crong.get(0)), findMaxNum(crong.get(1)));

        if (pobiMax > crongMax) {
            answer = 1;
        }
        else if (pobiMax < crongMax) {
            answer = 2;
        }
        else {
            answer = 0;
        }

        return answer;
    }

    public static int findMaxNum(int n) {
        int sum = 0, mul = 1;

        while (n > 0) {
            sum += n % 10;
            mul *= n % 10;
            n /= 10;
        }

        return Math.max(sum, mul);
    }
}