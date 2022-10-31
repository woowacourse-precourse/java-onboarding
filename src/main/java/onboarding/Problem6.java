package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

	private static class Crew {
		private final static int EMAIL_INDEX = 0;
		private final static int NICKNAME_INDEX = 1;
		private final static String EMAIL_DOMAIN = "@email.com";
		private final static String NULL = "";
		private final String email;
		private final String nickname;

		private Crew(List<String> form) {
			this.email = form.get(EMAIL_INDEX);
			this.nickname = form.get(NICKNAME_INDEX);
		}
		private ArrayList<String> generateNicknamePieces() {
			ArrayList<String> nicknamePieces = new ArrayList<>();
			Queue<String> queue = new LinkedList<>();

			for (String currentWord : nickname.split("")) {
				if (queue.isEmpty()) {
					queue.add(currentWord);
					continue;
				}
				queue.add(currentWord);
				String nicknamePiece = queue.poll().concat(currentWord);
				nicknamePieces.add(nicknamePiece);
			}
			return nicknamePieces;
		}

		private boolean isNicknameSimilarWith(ArrayList<String> nicknamePieces) {
			for (String nicknamePiece : nicknamePieces) {
				if (nickname.contains(nicknamePiece)) {
					return true;
				}
			}
			return false;
		}

		public String getDomainRemovedEmail() {
			return email.replace(EMAIL_DOMAIN, NULL);
		}

		public static String email(Crew crew) {
			return crew.email;
		}
	}

	private static class Woowacourse {
		ArrayList<Crew> crews = new ArrayList<>();
		HashSet<Crew> nicknameLimitedCrews = new HashSet<>();


		Woowacourse(List<List<String>> forms) {
			for (List<String> form : forms) {
				crews.add(new Crew(form));
			}
			findNicknameLimitedCrews();
		}

		private void findNicknameLimitedCrews() {
			for (Crew currentCrew : crews) {
				crews.stream()
					.filter(crew -> crew != currentCrew)
					.filter(crew -> crew.isNicknameSimilarWith(currentCrew.generateNicknamePieces()))
					.forEach(nicknameLimitedCrews::add);
			}
		}

		public List<String> getNicknameLimitedCrewsEmail() {
			return nicknameLimitedCrews.stream()
				.sorted(Comparator.comparing(Crew::getDomainRemovedEmail))
				.map(Crew::email)
				.collect(Collectors.toList());
		}
	}
}
