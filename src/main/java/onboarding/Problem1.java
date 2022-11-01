package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean page = exception(pobi, crong);
        if (!page) {
            return -1;
        }

        int pobi_sum = sum(pobi);
        int pobi_mul = mul(pobi);
        int pobi_max = max(pobi_sum, pobi_mul);

        int crong_sum = sum(crong);
        int crong_mul = mul(crong);
        int crong_max = max(crong_sum, crong_mul);


        if (pobi_max > crong_max) {
            return 1;
        } else if (pobi_max < crong_max) {
            return 2;
        } else if (pobi_max == crong_max) {
            return 0;
        } else {
            return -1;
        }


    }
    private static int sum(List<Integer> value) {

        int val1 = 0;
        int val2 = 0;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            val1 += Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array2) {
            val2 += Integer.valueOf(val);
        }
        return max(val1, val2);
    }

    private static int mul(List<Integer> value) {

        int val1 = 1;
        int val2 = 1;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            val1 = val1 * Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array2) {
            val2 = val2 * Integer.valueOf(val);
        }
        return max(val1, val2);
    }

    private static int max(int a, int b) {

        if (a > b) {
            return a;
        } else {
            return b;
        }

    }

    private static boolean exception(List<Integer> pobi, List<Integer> crong) {
        boolean ex = true;

        if (1 != Math.abs(pobi.get(0) - pobi.get(1))) {
            return false;
        } else if (1 != Math.abs(crong.get(0) - crong.get(1))) {
            return false;
        } else {
            return ex;
        }
    }
}