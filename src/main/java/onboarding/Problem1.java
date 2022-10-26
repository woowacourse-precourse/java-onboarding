package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(exs(pobi, crong)) return -1; // ex test

        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static boolean exs(List<Integer> pobi, List<Integer> crong) { // init exceptions true:ex / false:non-ex
        if(pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0) return true; // pobi left even or right odd
        if(crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) return true; // crong left even or right odd
        if((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) return true; // uncountinuous page numb
        if(pobi.get(0) < 1 || pobi.get(0) > 400 || pobi.get(1) < 1 || pobi.get(1) > 400) return true; // invalid pobi page numb
        if(crong.get(0) < 1 || crong.get(0) > 400 || crong.get(1) < 1 || crong.get(1) > 400) return true; // invalid crong page numb

        return false; // ex test pass
    }
}