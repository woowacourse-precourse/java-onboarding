package onboarding;

import java.util.Objects;

public class Problem2 {
    public static String solution(String cryptogram) {
        String temp = "";
        String[] te = cryptogram.split("");

        for (int i = 0; i < te.length; i++) {
            if (Objects.equals(temp, te[i])) {
                if (Objects.equals(te[i], "")) break;
                te[i] = "";
                te[i - 1] = "";
            }
            temp = te[i];
        }

        String answer = String.join("", te);
        System.out.println(answer);
        if (is_duplicate(answer))
            return solution(answer);
        return answer;
    }

    public static boolean is_duplicate(String cryptogram) {
        String temp = "";
        String[] te = cryptogram.split("");

        for (String s : te) {
            if (Objects.equals(temp, s)) {
                if (Objects.equals(s, "")) break;
                return true;
            }
            temp = s;
        }
        return false;
    }
}
