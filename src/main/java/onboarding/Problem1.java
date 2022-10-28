package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!check(pobi) || !check(crong)) return -1;

        int pobiMax = calculateMax(pobi);
        int crongMax = calculateMax(crong);

        if(pobiMax > crongMax) return 1;
        else if(pobiMax < crongMax) return 2;
        else return 0;
    }

    private static int calculateMax(List<Integer> name) {
        int left = name.get(0);
        int right = name.get(1);

        int sumMax = Math.max(calculateSum(left),calculateSum(right));
        int multMax = Math.max(calculateMult(left),calculateMult(right));

        return Math.max(sumMax, multMax);

    }

    private static int calculateMult(int num) {
        int mult = 1;
        while (num != 0) {
            mult *= (num % 10);
            num /= 10;
        }
        return mult;
    }

    private static int calculateSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    private static boolean check(List<Integer> name) {
        if (name.get(1) - name.get(0) != 1) return false;
        if(name.get(0) % 2 != 1 || name.get(1) % 2 != 0) return false;
        if(name.get(0) < 2 || name.get(1) > 399) return false;

        return true;
    }
}