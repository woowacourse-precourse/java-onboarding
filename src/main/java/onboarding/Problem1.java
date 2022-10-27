package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiMax = Math.max(findMaxNum(pobi.get(0)), findMaxNum(pobi.get(1)));
        int crongMax = Math.max(findMaxNum(crong.get(0)), findMaxNum(crong.get(1)));

        System.out.println(pobiMax);
        System.out.println(crongMax);

        return Math.max(pobiMax, crongMax);
    }

    public static int findMaxNum(int n) {
        int add = 0, mul = 0;

        for (n > 10) {
            int temp = n % 10;

            add += temp;
            mul *= temp;

            n /= 10;
        }

        return Math.max(add, mul);
    }
}