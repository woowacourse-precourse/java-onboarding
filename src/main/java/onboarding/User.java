package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private final String email;
    private final String nickName;
    private final List<String> splitList;

    public User(List<String> userInformation) {
        this.email = userInformation.get(0);
        this.nickName = userInformation.get(1);
        this.splitList = getSplitListByTwoLetters();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, nickName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return this.email.equals(user.email) &&
                this.nickName.equals(user.nickName);
    }

    public List<String> getSplitListByTwoLetters() {
        int p1 = 0;
        int p2 = 1;
        List<String> list = new ArrayList<>();
        while (p2 < nickName.length()) {
            list.add(nickName.substring(p1++, p2++ + 1));
        }
        return list;
    }

    public boolean compareSplitList(User user) {
        return user.splitList.stream()
                .anyMatch(splitList::contains);
    }
}
