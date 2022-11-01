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

    private static List<Trainee> validateEmailAndNickname(List<List<String>> forms) {
        List<Trainee> validTrainees = new ArrayList<>();
        for (List<String> form : forms) {
            if (validateEmail(form.get(0)) && validateNickname(form.get(1))) {
                validTrainees.add(new Trainee(form.get(0), form.get(1)));
            }
        }
        return validTrainees;
    }

    private static boolean validateNickname(String nickname) {
    }

    private static boolean validateEmail(String email) {
    }

}
