package onboarding.problem6.domain;

import java.util.List;
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
    public String toString() {
        return "User{" +
                "userName=" + userName +
                ", userEmail=" + userEmail +
                '}';
    }
}
