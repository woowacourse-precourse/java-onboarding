package onboarding.problem6.vo;

import java.util.Objects;

public class User {
    private final String email;
    private final String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static User of(String email, String name) {
        return new User(email, name);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User)o;
        return email.equals(user.email) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }
}
