package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Integer> list  = new ArrayList<>();
        list.add(0, 0);
        list.add(1, 0);
        for(int i = 2; i<10001; i++) {
            int count = 0;
            int j = i;
            while (j > 0) {
                if (j % 10 == 3 || j % 10 == 6 || j % 10 == 9) {
                    count++;
                }
                j = j / 10;
            }
            list.add(i, list.get(i - 1) + count);
        }
        return list.get(number);
    }
}
