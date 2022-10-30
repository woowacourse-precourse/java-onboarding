package onboarding;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		init(user, friends, visitors);
		return InMemoryDB.queryTop5FriendReferralList(user);
	}

	private static void init(String user, List<List<String>> friends, List<String> visitors) {
		friends.forEach(friend -> {
			final Member member1 = InMemoryDB.insertIfAbsentAndQueryMember(friend.get(0));
			final Member member2 = InMemoryDB.insertIfAbsentAndQueryMember(friend.get(1));
			member1.friend(member2);
		});
		final Member member = InMemoryDB.insertIfAbsentAndQueryMember(user);
		visitors.forEach(visitor -> InMemoryDB.insertIfAbsentAndQueryMember(visitor).visit(member));
	}

	public static class Member {

		private String username;
		private Set<Member> friends = new HashSet<>();
		private Map<Member, Integer> visitors = new HashMap<>();
		private int friendReferralScore = 0;

		private Member(String username) {
			this.username = username;
		}

		public static Member of(String username) {
			return new Member(username);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Member member = (Member)o;
			return Objects.equals(getUsername(), member.getUsername());
		}

		@Override
		public int hashCode() {
			return Objects.hash(getUsername());
		}

		public void initScore() {
			this.friendReferralScore = 0;
		}

		public void addScore(int score) {
			this.friendReferralScore += score;
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

		public String getUsername() {
			return username;
		}

		public Set<Member> getFriends() {
			return friends;
		}

		public Map<Member, Integer> getVisitors() {
			return visitors;
		}

		public int getFriendReferralScore() {
			return friendReferralScore;
		}

	}

	public static class InMemoryDB {

		private static final Map<String, Member> members = new HashMap<>();

		public static Member insertIfAbsentAndQueryMember(String username) {
			if (!members.containsKey(username)) {
				members.put(username, Member.of(username));
			}
			return members.get(username);
		}

		public static List<String> queryTop5FriendReferralList(String username) {
			final Member member = insertIfAbsentAndQueryMember(username);
			members.values().forEach(Member::initScore);
			updateScoreByVisitors(member);
			updateScoreByFriends(member);
			return members.values().stream()
				.filter(_member -> _member.getFriendReferralScore() != 0)
				.sorted(comparing(Member::getFriendReferralScore).reversed().thenComparing(Member::getUsername))
				.limit(5)
				.map(Member::getUsername)
				.collect(toList());
		}

		private static void updateScoreByFriends(Member member) {
			final Set<Member> friends = member.getFriends();
			members.values().stream()
				.filter(_member -> !_member.equals(member) && !friends.contains(_member))
				.forEach(_member -> _member.getFriends().stream()
					.filter(friends::contains)
					.forEach((f) -> _member.addScore(10))
				);
		}

		private static void updateScoreByVisitors(Member member) {
			final Set<Member> friends = member.getFriends();
			final Map<Member, Integer> visitors = member.getVisitors();
			visitors.keySet().stream()
				.filter(visitor -> !friends.contains(visitor))
				.forEach(visitor -> visitor.addScore(visitors.get(visitor)));
		}

	}

}
