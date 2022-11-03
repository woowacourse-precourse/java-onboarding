package onboarding.problem7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<Member> getAcquaintances(Member user) {
        List<Member> userFriends = getUserFriends(user);
        return userFriends.stream()
                .flatMap(userFriend -> Arrays.stream(memberListMap.get(userFriend).toArray()))
                .map(acquaintance -> (Member) acquaintance)
                .filter(acquaintance -> isNotUserAndUserFriend(user, userFriends, acquaintance))
                .collect(Collectors.toList());
    }

    public void upAcquaintancesPoint(List<Member> acquaintances, List<Member> userAndUserFriends) {
        for (Member acquaintance : acquaintances) {
            acquaintance.upAcquaintancePoint(userAndUserFriends);
        }
    }

    public void upVisitorsPoint(List<Member> visitors, List<Member> userAndUserFriends) {
        for (Member visitor : visitors) {
            visitor.upVisitorPoint(userAndUserFriends);
        }
    }

    public List<String> getSortedMemberNameList() {
        return memberListMap.keySet().stream()
                .filter(member -> member.getPoint() > 0)
                .sorted(Comparator.comparing(Member::getPoint).reversed()
                        .thenComparing(Member::getName))
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    private boolean isNotUserAndUserFriend(Member user, List<Member> userFriends, Member acquaintance) {
        if (user.equals(acquaintance) || userFriends.contains(acquaintance)) {
            return false;
        }
        return true;
    }

}
