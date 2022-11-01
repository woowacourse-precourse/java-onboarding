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

    public List<String> getWords() {
        String username = name.getName();
        List<String> userWords = new ArrayList<>();
        for (int i = 0; i < username.length() - 1; i++) {
            userWords.add(username.substring(i, i + 2));
        }
        return userWords;
    }

    public String getEmail() {
        return email.getEmail();
    }
}
