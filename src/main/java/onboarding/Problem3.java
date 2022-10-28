package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        List<String> list = makeList(number);

        for (String str : list) {
            if (doesStringContain369(str)) {
                answer += howManyStringContains369(str);
            }
        }

        return answer;
    }

    static List<String> makeList(int bounder) {
        List<String> arr = new ArrayList<>();

        for (int i = 1; i <= bounder; i++) {
            arr.add(String.valueOf(i));
        }

        return arr;
    }

    static boolean doesStringContain369(String str) {

        return str.contains("3") || str.contains("6") || str.contains("9");
    }

    static int howManyStringContains369(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
                count++;
            }
        }

        return count;
    }
}
