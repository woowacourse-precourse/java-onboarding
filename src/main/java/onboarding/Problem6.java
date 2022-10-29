package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        return answer;
    }

    public static boolean isDuplicated(String nick1, String nick2) {
        for (int i = 0; i < nick1.length() - 1; i++) {
            for (int j = 0; j < nick2.length() - 1; j++) {
                if (nick1.charAt(i) == nick2.charAt(j) && i < nick1.length() - 1) {
                    if (nick1.charAt(i + 1) == nick2.charAt(j + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
