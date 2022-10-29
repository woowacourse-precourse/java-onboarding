package onboarding;

import java.util.List;

public class Problem6 {
    static class Crew {
        private String email;
        private String nickname;

        public Crew(List<String> list) {
            this.email = list.get(0);
            this.nickname = list.get(1);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
