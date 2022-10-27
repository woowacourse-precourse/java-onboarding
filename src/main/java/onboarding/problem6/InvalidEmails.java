package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvalidEmails {

    private List<String> emails;

    protected InvalidEmails() {
        this.emails = new ArrayList<>();
    }

    public void add(String email) {
        if (alreadyExistEmail(email)) {
            return;
        }
        emails.add(email);
    }

    private boolean alreadyExistEmail(String email) {
        return emails.contains(email);
    }

    public List<String> getEmailsAsc() {
        return emails.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }
}
