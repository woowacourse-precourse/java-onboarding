package onboarding.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EmailSender {
    private final HashSet<String> duplicateCrews = new HashSet<>();

    public EmailSender(List<List<String>> forms) {
        for (int i = 0; i < forms.size() - 1; i++) {
            compareCrew(i, forms);
        }
    }

    private void compareCrew(int currentIndex, List<List<String>> forms) {
        for (int i = currentIndex + 1; i < forms.size(); i++) {
            checkCrewsNickname(forms.get(currentIndex), forms.get(i));
        }
    }

    private void checkCrewsNickname(List<String> currentCrew, List<String> anotherCrew) {
        if (isDuplicateNickname(currentCrew.get(1), anotherCrew.get(1))) {
            duplicateCrews.add(currentCrew.get(0));
            duplicateCrews.add(anotherCrew.get(0));
        }
    }

    private boolean isDuplicateNickname(String currentNickname, String anotherNickname) {
        boolean isDuplicate = false;
        for (int i = 0; i < anotherNickname.length() - 1; i++) {
            isDuplicate |= currentNickname.contains(anotherNickname.substring(i, i + 2));
        }

        return isDuplicate;
    }

    public List<String> sendEmail() {
        ArrayList<String> duplicateCrewsEmail = new ArrayList<>(duplicateCrews);
        duplicateCrewsEmail.sort(String::compareTo);
        return duplicateCrewsEmail;
    }
}
