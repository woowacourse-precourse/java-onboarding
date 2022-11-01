package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final Email email;
    private final Name name;

    public User(String email, String name) {
        this.email = new Email(email);
        this.name = new Name(name);
    }

    public String getEmail() {
        return email.getEmail();
    }
}
