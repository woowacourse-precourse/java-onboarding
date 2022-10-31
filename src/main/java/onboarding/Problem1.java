package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean page = validation(pobi,crong);
        int answer = Integer.MAX_VALUE;
        if(!page){
            return -1;
        }
        return 0;
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