package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    public static boolean compareNicknames(char[] nick1, char[] nick2) {
        for (int i = 1; i < nick1.length; i++) {
            for (int j = 1; j < nick2.length; j++)
                if (nick1[i - 1] == nick2[j - 1] && nick1[i] == nick2[j])
                    return true;
        }
        return false;
    }
}
