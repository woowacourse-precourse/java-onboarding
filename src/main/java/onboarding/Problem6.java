package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    
    public static class Member {
        private String email;
        private String name;

        private Member(String email, String name) {
            this.email = email;
            this.name = name;
        }

        public static Member of(List<String> form) {
            return new Member(form.get(0), form.get(1));
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }
    }
}
