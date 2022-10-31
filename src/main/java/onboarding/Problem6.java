package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        List<String> result = new ArrayList<>();

        List<User> userList = forms.stream()
                .map(User::new)
                .collect(Collectors.toList());

        for (User user1 : userList) {
            for (User user2 : userList) {
                if (user1.isNicknameInclude(user2)) {
                    result.add(user1.getEmail());
                }
            }
        }

        return result.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
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
