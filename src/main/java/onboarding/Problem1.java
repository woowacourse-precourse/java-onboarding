package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!check(pobi) || !check(crong)) return -1;
    }

    private static boolean check(List<Integer> name) {
        if (name.get(1) - name.get(0) != 1) return false;
        if(name.get(0) % 2 != 1 || name.get(1) % 2 != 0) return false;
        return true;
    }
}