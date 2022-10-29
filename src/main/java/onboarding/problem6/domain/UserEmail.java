package onboarding.problem6.domain;

import java.util.Objects;

public class UserEmail {
    private final String userEmail;
    
    public UserEmail(final String userEmail) {
        this.userEmail = userEmail;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserEmail userEmail1 = (UserEmail) o;
        return Objects.equals(userEmail, userEmail1.userEmail);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userEmail);
    }
    
    @Override
    public String toString() {
        return "UserEmail{" +
                "userEmail='" + userEmail + '\'' +
                '}';
    }
}
