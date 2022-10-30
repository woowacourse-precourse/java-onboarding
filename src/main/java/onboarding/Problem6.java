package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

    private static class User {
        private String email;
        private String nickname;

        public User(List<String> userList) {
            this.email = userList.get(0);
            this.nickname = userList.get(1);
        }

        public String getEmail() {
            return email;
        }
        public String getNickname() {
            return nickname;
        }
    }
}
