package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        List<Member> members = initialize(forms);

        return answer;
    }

    private static List<Member> initialize(List<List<String>> forms) {
        List<Member> members = new ArrayList<>();
        String email;
        String nickname;

        for(List<String> person : forms) {
            email = person.get(0);
            nickname = person.get(1);

            members.add(new Member(email, nickname));
        }

        return members;
    }

    private static class Member {
        private final String email;
        private final String nickname;

        public Member(String email, String nickname) {
            isValidEmail(email);
            isValidNickname(nickname);
            this.email = email;
            this.nickname = nickname;
        }

        private void isValidEmail(String email) {
            int length = email.length();
            if(11 <= length && length <= 20) {
                throw new IllegalArgumentException("이메일의 길이가 적절하지 않습니다.");
            }
            if(!email.endsWith("@email.com")) {
                throw new IllegalArgumentException("이메일의 형식이 적합하지 않습니다.");
            }
        }

        private void isValidNickname(String nickname) {
            int length = nickname.length();
            if(length < 1 || 20 < length) {
                throw new IllegalArgumentException("닉네임의 길이가 적절하지 않습니다.");
            }
        }
    }
}
