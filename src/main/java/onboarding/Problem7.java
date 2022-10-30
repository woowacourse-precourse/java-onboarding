package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
