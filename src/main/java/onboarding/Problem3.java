package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    static List<String> makeList(int bounder) {
        List<String> arr = new ArrayList<>();

        for (int i = 1; i <= bounder; i++) {
            arr.add(String.valueOf(i));
        }

        return arr;
    }
}
