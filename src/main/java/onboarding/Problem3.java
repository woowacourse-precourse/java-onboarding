package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        List<Character> numList = new ArrayList<>();
        for (int i = 1; i < number + 1; i++) {
            String numStr = String.valueOf(i);
            char[] numArr = numStr.toCharArray();
            for (char c : numArr) {
                numList.add(c);
            }
        }

        int count = 0;
        return count;
    }
}
