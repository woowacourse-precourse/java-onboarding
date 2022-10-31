package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }

	private static class Crew {
		private final static int EMAIL_INDEX = 0;
		private final static int NICKNAME_INDEX = 1;
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

	}
}
