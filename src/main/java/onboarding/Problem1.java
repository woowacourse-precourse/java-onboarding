package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int[] pobiArray = pobi.stream().mapToInt(Integer::intValue).toArray();
        int[] crongArray = crong.stream().mapToInt(Integer::intValue).toArray();
        boolean error = validate(pobi,crong);
        if(error){
            return -1;
        }

        int pobi_sum = sum(pobiArray);
        int pobi_mul = mul(pobiArray);
        int pobi_max = 0;
        if(pobi_sum > pobi_mul){
            pobi_max = pobi_sum;
        }else {
            pobi_max = pobi_mul;
        }


        int crong_sum = sum(crongArray);
        int crong_mul = mul(crongArray);
        int crong_max = 0;
        if(crong_sum > crong_mul){
            crong_max = crong_sum;
        }else {
            crong_max = crong_mul;
        }


        if(pobi_max > crong_max){
            return 1;
        }else if(crong_max > pobi_max){
            return 2;
        }else if(pobi_max == crong_max){
            return 0;
        }else{
            return -1;
        }

    }
    static private int sum(int[] value){
        int val1 = 0;
        int val2 = 0;

        String[] valArray1 = String.valueOf(value[0]).split("");
        for (String val : valArray1){
            val1 = val1 + Integer.valueOf(val);
        }
        String[] valArray2 = String.valueOf(value[1]).split("");
        for (String val:valArray2){
            val2 = val2 + Integer.valueOf(val);
        }
        if(val1 > val2){
            return val1;
        }else {
            return val2;
        }
    }

    static private int mul(int[] value){
        int val1 = 1;
        int val2 = 1;

        String[] valArray1 = String.valueOf(value[0]).split("");
        for (String val : valArray1){
            val1 = val1 * Integer.valueOf(val);
        }
        String[] valArray2 = String.valueOf(value[1]).split("");
        for (String val:valArray2){
            val2 = val2 * Integer.valueOf(val);
        }
        if(val1 > val2){
            return val1;
        }else {
            return val2;
        }

    }
    static private boolean validate(List<Integer>pobi, List<Integer> crong){

        int[] pobiArray = pobi.stream().mapToInt(Integer::intValue).toArray();
        int[] crongArray = crong.stream().mapToInt(Integer::intValue).toArray();
        if(1 != Math.abs(pobiArray[0] - pobiArray[1])){
            return true;
        }else if((1 != Math.abs(crongArray[0] - crongArray[1]))){
            return true;
        }else {
            return false;
        }
    }
}
