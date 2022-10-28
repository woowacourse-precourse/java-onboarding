package onboarding.domain;

import java.util.HashSet;
import java.util.List;

public class EmailSender {
    private final HashSet<String> duplicateCrews;

    public EmailSender(List<List<String>> forms) {
        this.duplicateCrews = extractDuplicateCrew(forms);
    }

    private HashSet<String> extractDuplicateCrew(List<List<String>> forms) {
        return null;
    }

    private boolean isDuplicateNickname(String currentNickname, String anotherNickname) {
        boolean isDuplicate = false;
        for (int i = 0; i < anotherNickname.length() - 1; i++) {
            isDuplicate |= currentNickname.contains(anotherNickname.substring(i, i + 2));
        }

        return isDuplicate;
    }
}
