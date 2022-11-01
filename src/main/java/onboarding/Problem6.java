package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        HashSet<String> emailsToBeNotified = new HashSet<>();

        for (List<String> form : forms) {
            String crewEmail = form.get(0);
            String crewNickname = form.get(1);
            int nicknameLength = crewNickname.length();

            for (int i = 0; i < nicknameLength - 1; i++) {
                String crewNicknameSubstring = crewNickname.substring(i, i + 2);
                addEmailsOfCrewWithDuplicateNickname(forms, crewEmail, crewNicknameSubstring, emailsToBeNotified);
            }
        }

        ArrayList<String> emailsToBeNotifiedList = new ArrayList<>(emailsToBeNotified);
        Collections.sort(emailsToBeNotifiedList);

        return emailsToBeNotifiedList;
    }

    private static void addEmailsOfCrewWithDuplicateNickname(List<List<String>> forms, String crewEmail, String crewNicknameSubstring, HashSet<String> emailsToBeNotified) {
        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (!emailsToBeNotified.contains(email) && !email.equals(crewEmail)) {
                if (nickname.contains(crewNicknameSubstring)) {
                    emailsToBeNotified.add(email);
                }
            }
        }
    }
}
