package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> duplicatedTraineeEmail = new ArrayList<>();
        List<Trainee> validTrainees = validateEmailAndNickname(forms);

        return getEmailOfDuplicatedNicknameTrainee(validTrainees);

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
        return nickname.length() > 1 && nickname.length() < 20;
    }

    private static boolean validateEmail(String email) {
        return email.length() > 10 && email.length() < 20;
    }

    private static List<String> getEmailOfDuplicatedNicknameTrainee(List<Trainee> validTrainees) {
        HashSet<String> emailSet = new HashSet<String>();

        for (int i = 0; i < validTrainees.size() - 1; i++) {
            for (int j = i+1; j < validTrainees.size(); j++) {
                addEmailSetWhenDuplicatedByTwoCharacter(validTrainees.get(i), validTrainees.get(j), emailSet);
            }
        }
        ArrayList<String> emailList = new ArrayList<>(emailSet);
        Collections.sort(emailList);
        return emailList;
    }

    private static void addEmailSetWhenDuplicatedByTwoCharacter(Trainee trainee1, Trainee trainee2, HashSet<String> emailSet) {
        if (isDuplicatedByTwoCharacter(trainee1, trainee2)) {
            emailSet.add(trainee1.getEmail());
            emailSet.add(trainee2.getEmail());
        }
    }
    private static boolean isDuplicatedByTwoCharacter(Trainee trainee1, Trainee trainee2) {

    }
}
