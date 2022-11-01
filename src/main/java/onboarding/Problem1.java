package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        boolean page = exception_check(pobi, crong);
        if(!page) {
            return -1;
        }

        int pobi_sum_score = sum(pobi);
        int pobi_mul_score = mul(pobi);
        int pobi_max_score = maxScore(pobi_sum_score, pobi_mul_score);

        int crong_sum_score = sum(pobi);
        int crong_mul_score = mul(pobi);
        int crong_max_score = maxScore(crong_sum_score, crong_mul_score);

        if(pobi_max_score > crong_max_score){
            return 1;
        } else if (pobi_max_score < crong_max_score) {
            return 2;
        } else if (pobi_max_score == crong_max_score) {
            return 0;
        } else return -1;
    }

    static private int sum(List<Integer> value) {
        int val_1 = 0;
        int val_2 = 0;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            val_1 = val_1 + Integer.valueOf(val);
        }
        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array1) {
            val_2 = val_2 + Integer.valueOf(val);
        }
        return  maxScore(val_1, val_2);
    }
    static private int mul(List<Integer> value) {
        int val_1 = 0;
        int val_2 = 0;

        String[] array1 = String.valueOf(value.get(0)).split("");
        for (String val : array1) {
            val_1 = val_1 * Integer.valueOf(val);
        }
        String[] array2 = String.valueOf(value.get(1)).split("");
        for (String val : array1) {
            val_2 = val_2 * Integer.valueOf(val);
        }
        return  maxScore(val_1, val_2);
    }
    static private int maxScore(int a, int b) {
        if(a > b){
            return a;
        }else return b;
    }

    static private boolean exception_check(List<Integer> pobi, List<Integer> crong){
        boolean result = true;

        if (1 != Math.abs(pobi.get(0) - pobi.get(1))){
            return false;
        } else if (1 != Math.abs(crong.get(0) - crong.get(1))) {
            return false;
        } else return result;
    }

}