package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class InvalidEmails {

    private List<String> emails;

    protected InvalidEmails() {
        this.emails = new ArrayList<>();
    }

    public void add(String email) {
        emails.add(email);
    }
}
