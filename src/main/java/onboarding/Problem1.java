package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = -1;
        boolean exception_pobi = validation(pobi);
        boolean exception_crong = validation(crong);

        if(!exception_pobi || !exception_crong) {
            return answer;
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
        int val_1 = 1;
        int val_2 = 1;

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

    static private boolean validation(List<Integer> list) {

        boolean result = true;
        for (int page : list) {
            if (page == 0 || page == 401) {
                return false;
            }
        }

        if (1 != (list.get(1) - list.get(0))) {
            return false;
        } else if (list.get(0) % 2 != 1) {
            return false;
        } else {
            return result;
        }
    }

}