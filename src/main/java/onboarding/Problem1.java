package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isPageOutOfRange(pobi) || isPageOutOfRange((crong)) || isPageSubDiff((pobi)) || isPageSubDiff((crong))) {
            return -1;
        }

        int answer = Integer.MAX_VALUE;
        return 0;
    }
    private static int sum(List<Integer> l){
        int val1 = 0;
        int val2 = 0;
        String[] arr1 = String.valueOf(l.get(0)).split("");
        String[] arr2 = String.valueOf(l.get(1)).split("");
        for(String val : arr1){
            val1 = val1 + Integer.valueOf(val);
        }
        for(String val : arr2){
            val2 = val2 + Integer.valueOf(val);
        }
        return max(val1,val2);
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
            return false;
        } else if(arr.get(0) < 1 || arr.get(1) < 1){
            return false;
        }else{
            return true;
        }
    }
    private static boolean isPageSubDiff(List<Integer> arr) {
        if (arr.get(1) - arr.get(0) != 1) {
            return false;
        } else {
            return true;
        }
    }
}