package onboarding.problem7;

import java.util.List;
import java.util.Map;

public class Members {
    private Map<Member, List<Member>> memberListMap;

    public Members(Map<Member, List<Member>> memberListMap) {
        this.memberListMap = memberListMap;
    }

    public List<Member> getUserAndUserFriends(Member user) {
        List<Member> userFriends = getUserFriends(user);
        userFriends.add(user);
        return userFriends;
    }

    public List<Member> getUserFriends(Member user) {
        return this.memberListMap.get(user);
    }
}
