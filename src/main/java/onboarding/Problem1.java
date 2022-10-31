package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //예외 체크
        if (exceptionCheck(pobi,crong)){
            return -1;
        }

        return -1;
    }

    public static boolean exceptionCheck(List<Integer> pobi, List<Integer> crong){
        if (pobi.get(0) % 2 != 1 || pobi.get(1) != pobi.get(0) + 1) {
            return true;
        }
        if (crong.get(0) % 2 != 1 || crong.get(1) != crong.get(0) + 1) {
            return true;
        }
        if (pobi.get(0) <= 0 || pobi.get(0) > 400 || pobi.get(1) <= 0 || pobi.get(1) > 400) {
            return true;
        }
        if (crong.get(0) <= 0 || crong.get(0) > 400 || crong.get(1) <= 0 || crong.get(1) > 400) {
            return true;
        }

        return false;
    }

}