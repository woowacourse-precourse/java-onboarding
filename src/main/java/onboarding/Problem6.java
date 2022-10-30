package onboarding;

import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
        final List<Member> members = forms.stream()
            .map(Member::of)
            .collect(Collectors.toList());
        return null;
    }

    public static class NicknameChecker {

    }

    public static class Member {
        private String email;
        private String nickname;

        private Member(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public static Member of(List<String> form) {
            return new Member(form.get(0), form.get(1));
        }

        public String getEmail() {
            return email;
        }

        public String getNickname() {
            return nickname;
        }

    }

}
