package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Member> memberMap = new HashMap<>();

        initFriendShip(memberMap, friends);

        initVisitor(user, memberMap, visitors);

        return getUsersByFriendProposalScoreLimit5(user, memberMap);
    }

    private static void initFriendShip(Map<String, Member> memberMap, List<List<String>> friends) {
        friends.forEach(friend -> {
            Member member1 = getMember(friend.get(0), memberMap);
            Member member2 = getMember(friend.get(1), memberMap);
            member1.friend(member2);
        });
    }

    private static void initVisitor(String user, Map<String, Member> memberMap, List<String> visitors) {
        Member member = getMember(user, memberMap);

        visitors.forEach(userId -> {
            Member visitor = getMember(userId, memberMap);
            visitor.visit(member);
        });
    }

    private static Member getMember(String user, Map<String, Member> members) {
        if (!members.containsKey(user)) {
            members.put(user, Member.of(user));
        }
        return members.get(user);
    }

    private static List<String> getUsersByFriendProposalScoreLimit5(String user, Map<String, Member> members) {
        Member member = getMember(user, members);

        calculateAcquaintances(member, members);

        calculateVisitor(member, members);

        return members.values().stream()
                .filter(_member -> _member.getFriendProposalScore() != 0)
                .sorted(Comparator.comparing(Member::getFriendProposalScore).reversed().thenComparing(Member::getUserId))
                .limit(5)
                .map(Member::getUserId)
                .collect(Collectors.toList());
    }

    private static void calculateAcquaintances(Member member, Map<String, Member> members) {

        Set<Member> friends = member.getFriends();

        members.values().stream()
                .filter(_member -> !_member.equals(member) && !friends.contains(_member))
                .forEach(_member -> _member.getFriends().stream()
                        .filter(friends::contains)
                        .forEach(add -> _member.addFriendProposalScore(10))
                );
    }

    private static void calculateVisitor(Member member, Map<String, Member> members) {
        Set<Member> friends = member.getFriends();
        Map<Member, Integer> visitors = member.getVisitors();

        visitors.keySet().stream()
                .filter(visitor -> !friends.contains(visitor))
                .forEach(visitor -> visitor.addFriendProposalScore(visitors.get(visitor)));
    }

    public static class Member {

        private String userId;
        private Set<Member> friends = new HashSet<>();
        private Map<Member, Integer> visitors = new HashMap<>();
        private int friendProposalScore;

        private Member(String userId) {
            this.userId = userId;
        }

        public static Member of(String userId) {
            return new Member(userId);
        }

        public String getUserId() {
            return userId;
        }

        public Set<Member> getFriends() {
            return friends;
        }

        public Map<Member, Integer> getVisitors() {
            return visitors;
        }

        public void friend(Member member) {
            this.friends.add(member);
            member.getFriends().add(this);
        }

        public void visit(Member member) {
            if (member.getVisitors().containsKey(this)) {
                member.getVisitors().replace(this, member.getVisitors().get(this) + 1);
            } else {
                member.getVisitors().put(this, 1);
            }
        }

        public void addFriendProposalScore(int friendProposalScore) {
            this.friendProposalScore += friendProposalScore;
        }

        public int getFriendProposalScore() {
            return friendProposalScore;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Member member = (Member) o;
            return userId.equals(member.userId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId);
        }
    }

}
