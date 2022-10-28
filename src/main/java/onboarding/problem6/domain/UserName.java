package onboarding.problem6.domain;

import java.util.Objects;

public class UserName {
    private final String userName;
    
    public UserName(final String userName) {
        this.userName = userName;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserName userName1 = (UserName) o;
        return Objects.equals(userName, userName1.userName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
