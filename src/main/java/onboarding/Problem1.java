package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        answer = 0;
        if (isPageOutOfRange(pobi) || isPageOutOfRange((crong)) || isPageSubDiff((pobi)) || isPageSubDiff((crong))) {
            return -1;
        }
        if(calPageMaxSumMul(pobi) > calPageMaxSumMul(crong)) answer = 1;
        if(calPageMaxSumMul(pobi) < calPageMaxSumMul(crong)) answer = 2;
        return answer;
    }
    private static int calPageMaxSumMul(List<Integer> l){
        int sumTemp1 = 0;
        int sumTemp2 = 0;
        String[] arr1 = String.valueOf(l.get(0)).split("");
        String[] arr2 = String.valueOf(l.get(1)).split("");
        for(String val : arr1){
            sumTemp1 = sumTemp1 + Integer.valueOf(val);
        }
        for(String val : arr2){
            sumTemp2 = sumTemp2 + Integer.valueOf(val);
        }
        int maxSum =  max(sumTemp1,sumTemp2);
        int mulTemp1 = 1;
        int mulTemp2 = 1;
        for(String val : arr1){
            mulTemp1 = mulTemp1 * Integer.valueOf(val);
        }
        for(String val : arr2){
            mulTemp2 = mulTemp2 * Integer.valueOf(val);
        }
        int maxMul =  max(mulTemp1,mulTemp2);
        return max(maxSum, maxMul);
    }

    private static int max(int a, int b){
        if(a>b){
            return a;
        } else{
            return b;
        }
    }
    private static boolean isPageOutOfRange(List<Integer> arr){
        if(arr.get(0) > 400 || arr.get(1) > 400){
            return true;
        } else if(arr.get(0) < 1 || arr.get(1) < 1){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isPageSubDiff(List<Integer> arr) {
        if (arr.get(1) - arr.get(0) != 1) {
            return true;
        } else {
            return false;
        }
    }
}