package onboarding.problem7;

import java.util.List;
import java.util.Map;

public abstract class FriendRecommender {

    protected final Map<String,Member> memberMap;

    public FriendRecommender(Map<String, Member> memberMap) {
        this.memberMap = memberMap;
    }

    /**
     * 7.3.1
     * 두 멤버가 친구사이인지 판별
     */
    public boolean isFriend(String userName, String memberName) {
        Member user = memberMap.get(userName);
        Member member = memberMap.get(memberName);

        return user.isFriendOf(member);
    }

    /**
     * 7.3.2
     * 두 멤버가 같은 친구 coFriend를 맺고 있는지 판별
     */
    public boolean hasCoFriend(String userName, String memberName) {
        List<Member> userFriends = memberMap.get(userName).getFriends();
        List<Member> memberFriends = memberMap.get(memberName).getFriends();

        if (hasDuplicate(userFriends,memberFriends))
            return true;

        return false;
    }

    // 두 리스트에 공통되는 레퍼런스가 있는지 판별
    public boolean hasDuplicate(List<Member> userFriends, List<Member> memberFriends) {
        for (Member userFriend : userFriends)
            for (Member memberFriend : memberFriends)
                if (userFriend.equals(memberFriend))
                    return true;

        return false;
    }


    /*-----추상 메소드-----*/
    public abstract List<Member> recommendFor(String userName);
}
