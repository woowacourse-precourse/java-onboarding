package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(isNotValid(pobi, crong)) return -1;
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean isNotValid(List<Integer> pobi, List<Integer> crong) {
        if(pobi.size() != 2 || crong.size() != 2) return true;
        if(pobi.get(0) < 2 || pobi.get(0) > 400 || crong.get(0) < 2 && crong.get(1) > 399) return true;
        if((pobi.get(1) - pobi.get(0)) != 1 || (crong.get(1) - crong.get(0)) != 1) return true;
        return false;
    }
}