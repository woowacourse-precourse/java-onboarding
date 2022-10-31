package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        String temp = "";
        String[] values = cryptogram.split("");

        for (int i = 0; i < values.length; i++) {
            if (Objects.equals(temp, values[i])) {
                if (Objects.equals(values[i], "")) break;
                values[i] = "";
                values[i - 1] = "";
            }
            temp = values[i];
        }

        String answer = String.join("", values);
        System.out.println(answer);
        if (is_duplicate(answer))
            return solution(answer);
        return answer;
    }

    public static boolean is_duplicate(String cryptogram) {
        String temp = "";
        String[] values = cryptogram.split("");

        for (String s : values) {
            if (Objects.equals(temp, s)) {
                if (Objects.equals(s, "")) break;
                return true;
            }
            temp = s;
        }
        return false;
    }
}
