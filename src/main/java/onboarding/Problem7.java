package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Map<String, Member> memberMap = new HashMap<>();

        initFriendShip(memberMap, friends);

        Member member = getMember(memberMap, user);

        visitors.forEach(userId -> {
            Member visitor = getMember(memberMap, userId);
            visitor.visit(member);
        });

        return getUserIdsByFriendProposalScoreLimit5(memberMap, user);
    }

    private static void initFriendShip(Map<String, Member> memberMap, List<List<String>> friends) {
        friends.forEach(friend -> {
            Member member1 = getMember(memberMap, friend.get(0));
            Member member2 = getMember(memberMap, friend.get(1));
            member1.friend(member2);
        });
    }

    private static Member getMember(Map<String, Member> members, String userId) {
        if (!members.containsKey(userId)) {
            members.put(userId, Member.of(userId));
        }
        return members.get(userId);
    }

    private static List<String> getUserIdsByFriendProposalScoreLimit5(Map<String, Member> members, String userId) {
        Member member = getMember(members, userId);

        Set<Member> friends = member.getFriends();

        members.values().stream()
                .filter(_member -> !_member.equals(member) && !friends.contains(_member))
                .forEach(_member -> _member.getFriends().stream()
                        .filter(friends::contains)
                        .forEach(add -> _member.addFriendProposalScore(10))
                );

        Map<Member, Integer> visitors = member.getVisitors();

        visitors.keySet().stream()
                .filter(visitor -> !friends.contains(visitor))
                .forEach(visitor -> visitor.addFriendProposalScore(visitors.get(visitor)));

        return members.values().stream()
                .filter(_member -> _member.getFriendProposalScore() != 0)
                .sorted(Comparator.comparing(Member::getFriendProposalScore).reversed().thenComparing(Member::getUserId))
                .limit(5)
                .map(Member::getUserId)
                .collect(Collectors.toList());
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
