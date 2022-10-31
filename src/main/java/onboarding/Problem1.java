package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int p = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;

        if (pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1 || crong.get(0) % 2 == 0 || crong.get(1) % 2 == 1
            || pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }


        for (int i = 0; i < pobi.size(); i++) {
            p = Math.max(p, getSum(String.valueOf(pobi.get(i))));
            p = Math.max(p, getMultiply(String.valueOf(pobi.get(i))));

            c = Math.max(c, getSum(String.valueOf(crong.get(i))));
            c = Math.max(c, getMultiply(String.valueOf(crong.get(i))));
        }

        if (p > c) {
            return 1;
        }

        else if (p == c) {
            return 0;
        }

        else {
            return 2;
        }
    }

    public static int getSum(String num) {
        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i) - '0';
        }

        return sum;
    }

    public static int getMultiply(String num) {
        int multiply = 1;

        for (int i = 0; i < num.length(); i++) {
            multiply *= num.charAt(i) - '0';
        }

        return multiply;
    }
}