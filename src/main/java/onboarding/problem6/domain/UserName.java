package onboarding.problem6.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserName {
    private final String userName;
    
    public UserName(final String userName) {
        this.userName = userName;
    }
    
    public List<UserName> twoLetterNames() {
        return IntStream.range(0, userName.length() - 1)
                .mapToObj(index -> userName.substring(index, index + 2))
                .map(UserName::new)
                .collect(Collectors.toList());
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
    
    @Override
    public String toString() {
        return "UserName{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
