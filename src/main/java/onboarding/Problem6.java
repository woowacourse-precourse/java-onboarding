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

        public boolean isNicknameInclude(User user) {
            if (user.getEmail().equals(email)) {
                return false;
            }
            for (int i = 0; i < nickname.length()-1; i++) {
                String token = nickname.substring(i, i+2);
                if (user.getNickname().contains(token)) {
                    return true;
                }
            }
            return false;
        }
    }
}
