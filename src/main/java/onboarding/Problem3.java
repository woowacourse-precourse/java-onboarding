package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        List<Integer> numList = new ArrayList<>(number);

        for (int i = 1; i <= number; i++) {
            numList.add(i);
        }

        return numCount(numList, count);
    }
}
