package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Problem7 {

	public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
		List<String> answer = Collections.emptyList();
		return answer;
	}

	public static class Member {

		private String username;
		private List<Member> friends = new ArrayList<>();
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

		public void addFriend(Member member) {
			this.friends.add(member);
		}

		public void visit(Member member) {
			if (this.visitors.containsKey(member)) {
				this.visitors.replace(member, this.visitors.get(member) + 1);
			} else {
				this.visitors.put(member, 1);
			}
		}

		public String getUsername() {
			return username;
		}

		public List<Member> getFriends() {
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

		private Map<String, Member> members = new HashMap<>();

	}

}
