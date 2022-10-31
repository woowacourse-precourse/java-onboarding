package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean page = validation(pobi, crong);
        if (!page) {
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
    private static boolean validation(List<Integer> pobi, List<Integer> crong){
        boolean result = true;
        int pobi0 = pobi.get(0);
        int pobi1 = pobi.get(1);
        int crong0 = crong.get(0);
        int crong1 = crong.get(1);
        if(1 != pobi1 - pobi0){
            return false;
        } else if(1 != crong1 - crong0){
            return false;
        } else if(pobi0 % 2 != 1 || crong0 % 2 != 1){
            return false;
        } else if(pobi1 % 2 != 0 || crong1 % 2 != 0){
            return false;
        } else if(pobi1 > 400 || crong1 > 400){
            return false;
        } else{
            return result;
        }
    }
}