package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        List<String> duplicatedTraineeEmail = new ArrayList<>();
        List<Trainee> validTrainees = validateEmailAndNickname(forms);


        return answer;
    }

    private static class Trainee {
        private String email;
        private String nickname;

        public Trainee(String email, String nickname) {
            this.email = email;
            this.nickname = nickname;
        }

        public String getEmail() {
            return email;
        }

        public String getNickname() {
            return nickname;
        }
    }
}
