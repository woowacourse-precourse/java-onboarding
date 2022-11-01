package onborading;

import com.sun.jdi.IntegerValue;
import java.util.List;
import java.util.ArrayList;

public class Problem1 {
    public int solution(int[] pobi, int[] crong){


        boolean page = validation(pobi, crong);
        if (!page) {
            return -1;
        }
        //포비 점수판
        int pobi_sum_score = sum(pobi);
        int pobi_mul_score = mul(pobi);

        int pobi_max_score = maxScore(pobi_sum_score,pobi_mul_score);

        //크롱 점수판
        int crong_sum_score = sum(crong);
        int crong_mul_score = mul(crong);

        int crong_max_score = maxScore(crong_sum_score,crong_mul_score);

        if (pobi_max_score > crong_max_score){
            return 1;

        }else if (pobi_max_score < crong_max_score){
            return 2;
        } else if (pobi_max_score == crong_max_score) {
            return 0;

        }else {
            return  -1;
        }

    }
    static private int sum(int[] value){

        int val_1 = 0;
        int val_2 = 0;

        String[] array1 = String.valueOf(value[0]).split("");
        for (String val : array1){
            val_1 = val_1 + Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value[1]).split("");
        for (String val : array2){
            val_2 = val_2 + Integer.valueOf(val);
        }

        return maxScore(val_1, val_2);
    }

    static private int mul(int value[]) {
        int val_1 = 1;
        int val_2 = 1;

        String[] array1 = String.valueOf(value[0]).split("");
        for (String val : array1) {
            val_1 = val_1 * Integer.valueOf(val);
        }
        String[] array2 = String.valueOf(value[1]).split("");
        for (String val : array1) {
            val_2 = val_2 * Integer.valueOf(val);
        }
        return maxScore(val_1, val_2);
    }
    // 다음번에는 삼항연산자로 깔끔하게 해보겠습니다.
    static private int maxScore(int a, int b){
        if (a > b){
            return a;
        }else {
            return b;
        }
    }
    static private boolean validation(int[] pobi,int[] crong) {
        boolean result = true;

        if (1 != Math.abs(pobi[0] - pobi[1])){
            return false;

        }else if (1 != Math.abs(crong[0] - crong[1])){
            return false;
        }else{
            return result;
        }
    }

}