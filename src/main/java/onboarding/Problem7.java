package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
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

        public void visitFriendTimeLine(Member member) {
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
    }

}
