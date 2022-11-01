package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import onboarding.problem6.crew.Crew;
import onboarding.problem6.twoletterword.InNickName;

public class DuplicatePool {
	private final static Map<Duplicative, Integer> duplicateWordRepository;

	static {
		duplicateWordRepository = new ConcurrentHashMap<>();
	}

	public synchronized static void fillByWord(String words, int wordLength) {
		String[] split = words.split("");

		StringBuilder word = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			appendLetter(wordLength, word, split[i]);
		}
	}

	public static List<Crew> findDuplicateNicknameCrews(List<Crew> crews) {
		List<Crew> duplicateNicknameCrews = new ArrayList<>();
		for (Crew crew : crews) {
			String nickname = crew.getNickname();
			String[] split = nickname.split("");

			StringBuilder word = new StringBuilder();
			for (int i = 0; i < split.length; i++) {
				word.append(split[i]);
				if (word.length() == 2
					&& isDuplicatedNickname(word.toString())) {
					duplicateNicknameCrews.add(crew);
					break;
				} else if (word.length() == 2) {
					word.deleteCharAt(0);
				}
			}
		}

		return duplicateNicknameCrews;
	}

	private static boolean isDuplicatedNickname(String word) {
		InNickName duplicative = new InNickName(word);
		if (duplicateWordRepository.get(duplicative) > 2) {
			return true;
		}
		return false;
	}

	private static void appendLetter(int wordLength, StringBuilder word, String split) {
		word.append(split);
		if (word.length() == wordLength) {
			addDuplicativeWord(word);
		}
	}

	private static void addDuplicativeWord(StringBuilder word) {
		InNickName duplicative = new InNickName(word.toString());
		Integer emergedCount = duplicateWordRepository.getOrDefault(duplicative, 0);
		duplicateWordRepository.put(
			duplicative,
			emergedCount + 1
		);

		word.deleteCharAt(0);
	}

}
