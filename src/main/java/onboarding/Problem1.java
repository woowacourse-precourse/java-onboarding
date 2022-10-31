package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isSatisfied(pobi) && isSatisfied(crong)) {
            int pobi_score = max(maxNumber(pobi.get(0)),maxNumber(pobi.get(1)));
            int crong_score = max(maxNumber(crong.get(0)),maxNumber(crong.get(1)));
            if (pobi_score > crong_score) {
                return 1;
            }
            if (pobi_score < crong_score) {
                return 2;
            }
            return 0;
        }
        return -1;
    }

    private static boolean isSatisfied(List<Integer> array) {
        return array.get(0) > 1 && array.get(0) < 399 && array.get(1) - array.get(0) == 1;
    }

    private static int maxNumber(int n) {
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