package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserMatchingList {

    private final List<Users> matchingUserList;
    private final Set<User> duplicatedUserList;

    public UserMatchingList(List<Users> matchingUserList) {
        this.matchingUserList = matchingUserList;
        this.duplicatedUserList = compareUserMatchingListAndFindDuplicatedUsers();
    }

    public Set<User> compareUserMatchingListAndFindDuplicatedUsers() {
        Set<User> duplicatedUserList = new HashSet<>();
        matchingUserList.stream()
                .filter(Users::compareUsers)
                .forEach(users -> duplicatedUserList.addAll(users.getUsers()));
        return duplicatedUserList;
    }
}
