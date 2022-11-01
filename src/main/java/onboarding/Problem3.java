package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            list.add(i + "");
        }
        String str = list.stream().reduce("", (a, b) -> a + b);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
                answer++;
            }
        }

        return answer;
    }
}