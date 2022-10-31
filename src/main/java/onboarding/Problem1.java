package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        int answer = Integer.MAX_VALUE;

        int[] arr = new int[pobi.size()];
        for (int i = 0; i < pobi.size(); i++) {
            arr[i] = pobi.get(i);
        }

        int[] arr2 = new int[crong.size()];
        for (int i = 0; i < crong.size(); i++) {
            arr2[i] = crong.get(i);
        }

        boolean page = validation(arr, arr2);

        if (!page) {
            return -1;
        }

        int pobi_sum_score = sum(arr);
        int pobi_mul_score = mul(arr);

        int pobi_max_score = maxScore(pobi_sum_score, pobi_mul_score);

        int crong_sum_score = sum(arr2);
        int crong_mul_score = mul(arr2);

        int crong_max_score = maxScore(crong_sum_score, crong_mul_score);

        if (pobi_max_score > crong_max_score) {
            return 1;
        } else if (pobi_max_score < crong_max_score) {
            return 2;
        } else if (pobi_max_score == crong_max_score) {
            return 0;
        } else {
            return -1;
        }
    }

    static private int sum(int[] value) {
        int val_1 = 0;
        int val_2 = 0;

        String[] array1 = String.valueOf(value[0]).split("");
        for (String val : array1) {
            val_1 = val_1 + Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value[0]).split("");
        for (String val : array2) {
            val_2 = val_2 + Integer.valueOf(val);
        }

        return maxScore(val_1, val_2);
    }

    static private int mul(int[] value) {
        int val_1 = 1;
        int val_2 = 1;

        String[] array1 = String.valueOf(value[0]).split("");

        for (String val : array1) {
            val_1 = val_1 + Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value[1]).split("");

        for (String val : array2) {
            val_2 = val_2 + Integer.valueOf(val);
        }

        return maxScore(val_1, val_2);
    }

    static private int maxScore(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static private boolean validation(int[] pobi, int[] crong) {
        boolean answer = true;

        if (1 != Math.abs(pobi[0] - pobi[1])) {
            return false;
        } else if (1 != Math.abs(crong[0] - crong[1])) {
            return false;
        } else {
            return answer;
        }

    }

}