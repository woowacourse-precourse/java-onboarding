package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();

        return answer;
    }

    private static class User {
        private String username;
        private List<User> friends;

        public String getUsername() {
            return this.username;
        }

        private List<User> getFriends() {
            return this.friends;
        }

        public User(String username) {
            isValidUsername(username);
            this.username = username;
            this.friends = new ArrayList<>();
        }

        private void isValidUsername(String username) {
            int length = username.length();
            if(length < 1 || 30 < length) {
                throw new IllegalArgumentException("닉네임의 길이가 적절치 않습니다.");
            }
        }
    }
}
