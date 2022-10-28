package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isValid(pobi, crong)){
            return -1;
        }



        return 0;
    }


    /**
     * 페이지의 범위가 옳바른지 체크
     * @param pobi
     * @param crong
     * @return
     */
    private static boolean isValid(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1);
    }

}