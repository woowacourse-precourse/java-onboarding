package onboarding;

import onboarding.problem7.Member;
import onboarding.problem7.Members;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Member> memberObjectMep = getMemberObjectMep(friends, visitors);
        Map<Member, List<Member>> friendsMap = getFriendsMap(friends, memberObjectMep);

        Members members = new Members(friendsMap);
        Member userMember = memberObjectMep.get(user);

        List<Member> userAndUserFriends = members.getUserAndUserFriends(userMember);
        List<Member> acquaintances = members.getAcquaintances(userMember);
        List<Member> visitorMembers = visitors.stream()
                .map(visitor -> memberObjectMep.get(visitor))
                .collect(Collectors.toList());

        members.upAcquaintancesPoint(acquaintances, userAndUserFriends);
        members.upVisitorsPoint(visitorMembers, userAndUserFriends);

        return members.getSortedMemberNameList();
    }

    public static Map<Member, List<Member>> getFriendsMap(List<List<String>> friends, Map<String, Member> memberObjectMap) {
        Map<Member, List<Member>> friendListMap = initFriendListMap(memberObjectMap);
        for (List<String> friendPair : friends) {
            Member member1 = memberObjectMap.get(friendPair.get(0));
            Member member2 = memberObjectMap.get(friendPair.get(1));
            List<Member> addedFriendList1 = getAddedFriendList(friendListMap.get(member1), member2);
            List<Member> addedFriendList2 = getAddedFriendList(friendListMap.get(member2), member1);
            friendListMap.put(member1, addedFriendList1);
            friendListMap.put(member2, addedFriendList2);
        }
        return friendListMap;
    }

    public static Map<String, Member> getMemberObjectMep(List<List<String>> friends, List<String> visitors) {
        return getMemberSet(friends, visitors).stream()
                .collect(Collectors.toMap(
                        member -> member,
                        member -> new Member(member, 0)
                ));
    }

    private static Set<String> getMemberSet(List<List<String>> friends, List<String> visitors) {
        Set<String> memberSet = friends.stream()
                .flatMap(friend -> Arrays.stream(friend.toArray()))
                .map(Object::toString)
                .collect(Collectors.toSet());
        memberSet.addAll(visitors);
        return memberSet;
    }

    private static List<Member> getAddedFriendList(List<Member> friendList, Member member) {
        friendList.add(member);
        return friendList;
    }

    private static Map<Member, List<Member>> initFriendListMap(Map<String, Member> memberObjectMap) {
        return memberObjectMap.values().stream()
                .collect(Collectors.toMap(
                        member -> member,
                        member -> new ArrayList<Member>()
                ));
    }
}
