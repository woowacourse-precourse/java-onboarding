package onboarding;

import java.util.ArrayList;
import java.util.List;

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
