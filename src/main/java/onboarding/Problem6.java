package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
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
