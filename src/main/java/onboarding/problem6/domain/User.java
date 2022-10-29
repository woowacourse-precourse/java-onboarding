package onboarding.problem6.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class User {
    private final UserName userName;
    private final UserEmail userEmail;
    
    public User(final String userName, final String userEmail) {
        this(new UserName(userName), new UserEmail(userEmail));
    }
    
    public User(final UserName userName, final UserEmail userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }
    
    public List<User> twoLetterNames() {
        return userName.twoLetterNames().stream()
                .map(twoLetterName -> new User(twoLetterName, userEmail))
                .collect(Collectors.toList());
    }
    
    public UserName getUserName() {
        return userName;
    }
    
    public UserEmail getUserEmail() {
        return userEmail;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(userName, userEmail);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userName=" + userName +
                ", userEmail=" + userEmail +
                '}';
    }
}
