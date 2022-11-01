package onboarding;

import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static HashSet<String> getSubNickNames(String nickName) {
        HashSet<String> subNickNames = new HashSet<>();
        for (int i = 0; i < nickName.length() - 1; i++) {
            subNickNames.add(nickName.substring(i, i + 2));
        }
        return subNickNames;
    }

    private enum Form {
        EMAIL(0),
        NICKNAME(1);

        private final int index;

        Form(int index) {
            this.index = index;
        }
    }
}
