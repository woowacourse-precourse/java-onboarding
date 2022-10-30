package onboarding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem6 {

	public static List<String> solution(List<List<String>> forms) {
		final List<Member> members = forms.stream()
			.map(Member::of)
			.collect(Collectors.toList());
		return NicknameChecker.getEmailListOfCrewsContainingSameLetterInNicknameConsecutively(members);
	}

	public static class NicknameChecker {

		public static Map<String, List<Member>> groupBySubstringInNickname(List<Member> members) {
			final Map<String, List<Member>> memberMap = new HashMap<>();
			members.forEach(member -> {
				final String nickname = member.getNickname();
				for (int i = 0; i < nickname.length() - 1; i++) {
					final String key = nickname.substring(i, i + 2);
					memberMap.putIfAbsent(key, new ArrayList<>());
					memberMap.get(key).add(member);
				}
			});
			return memberMap;
		}

		public static List<String> getEmailListOfCrewsContainingSameLetterInNicknameConsecutively(
			List<Member> members) {
			return groupBySubstringInNickname(members).values().stream()
				.filter(value -> value.size() > 1)
				.flatMap(Collection::stream)
				.map(Member::getEmail)
				.sorted()
				.collect(Collectors.toList());
		}

	}

	public static class Member {

		private String email;
		private String nickname;

		private Member(String email, String nickname) {
			this.email = email;
			this.nickname = nickname;
		}

		public static Member of(List<String> form) {
			return new Member(form.get(0), form.get(1));
		}

		public String getEmail() {
			return email;
		}

		public String getNickname() {
			return nickname;
		}

	}

}
