package onboarding.problem6.vo;

import java.util.Objects;

public class UserInfo {
    private final String email;
    private final String name;

    public UserInfo(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static UserInfo of(String email, String name) {
        return new UserInfo(email, name);
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
        if (!(o instanceof UserInfo))
            return false;
        UserInfo userInfo = (UserInfo)o;
        return email.equals(userInfo.email) && name.equals(userInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name);
    }
}
