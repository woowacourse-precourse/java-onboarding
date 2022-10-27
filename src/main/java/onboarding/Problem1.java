package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

    }
    public static boolean isError(List<Integer> pobi, List<Integer> crong) {
        for (int i = 0; i <= 1; i++) {
            if (!(0 < pobi.get(i) && pobi.get(i) <= 400)) {
                return true;
            }
            if (!(0 < crong.get(i) && crong.get(i) <= 400)) {
                return true;
            }
        }
        if (!((pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1)))) {
            return true;
        }
        if (!((pobi.get(1) % 2 == 0) && (crong.get(1) % 2 == 0))) {
            return true;
        }
        return false;
    }

}