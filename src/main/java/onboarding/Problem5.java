package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {
        if (money < 1 || money > 1000000)
            return null;
        int[] ret = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        for (int i = 0; i < 9; i++){
            int tmp = ret[i];
            ret[i] = money / ret[i];
            money = money % tmp;
        }
        return ((List<Integer>) Arrays.stream(ret).boxed().collect(Collectors.toList()));
    }
}
