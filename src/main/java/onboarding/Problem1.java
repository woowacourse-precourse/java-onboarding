package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isSatisfied(pobi) && isSatisfied(crong)) {

            }
            return answer;
        }
        return -1;
    }

    private static boolean isSatisfied(List<Integer> array) {
        return array.get(0) > 1 && array.get(0) < 399 && array.get(1) - array.get(0) == 1;
    }

    private static int maxScore(int n) {
        int rest;
        int sum = 0;
        int product = 1;
        while(n != 0){
            rest = n % 10;
            sum += rest;
            product *= rest;
            n /= 10;
        }
        return max(sum,product);
    }

}