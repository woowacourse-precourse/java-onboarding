package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        if (CheckException(pobi)) {
            return -1;
        }
        if (CheckException(crong)) {
            return -1;
        }

        return answer;
    }

    public static Boolean CheckException(List<Integer> Page){
        if (Page.get(0) + 1 != Page.get(1)) {
            return true;
        }
        return false;
    }


}