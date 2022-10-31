package onboarding;

import java.util.List;
import java.util.Set;

public class Problem6 {
    public static final int EMAIL_IDX = 0;
    public static final int NICKNAME_IDX = 1;

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static void getSimilarNicknameUser(List<List<String>> forms) {
        for (int i = 0; i <= forms.size() - 1; i++) {
            String nickname = forms.get(i).get(NICKNAME_IDX);

            for (int j = 0; j <= nickname.length() - 2; j++) {
                char[] charArray = {nickname.charAt(j), nickname.charAt(j + 1)};
                String continuous = String.valueOf(charArray);
            }
        }
    }
}
