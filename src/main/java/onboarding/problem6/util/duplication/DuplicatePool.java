package onboarding.problem6.util.duplication;

import static onboarding.problem6.Problem6Constant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import onboarding.problem6.util.duplication.model.InNickName;

public class DuplicatePool {
	private final static Map<Duplicative, Integer> duplicateWordRepository;

	static {
		duplicateWordRepository = new ConcurrentHashMap<>();
	}

	private DuplicatePool() {
	}

	public synchronized static void fillByWord(String words, int wordLength) {
		List<String> slicedWords = sliceWord(words, wordLength);
		for (String slicedWord : slicedWords) {
			addDuplicativeWord(slicedWord);
		}

	}

	public static boolean isDuplicateNickname(String nickname) {
		List<String> sliceWords = sliceWord(nickname, NICKNAME_DUPLICATE_WORD_LENGTH);
		for (String sliceWord : sliceWords) {
			if (isDuplicatedNickname(sliceWord)) {
				return true;
			};
		}

		return false;
	}

	private static List<String> sliceWord(String word, int size) {
		String[] split = word.split("");
		List<String> slicedWords = new ArrayList<>();

		StringBuilder slicedWord = new StringBuilder();
		for (int i = 0; i < split.length; i++) {
			slicedWord.append(split[i]);
			addToList(size, slicedWords, slicedWord);
		}

		return slicedWords;
	}

	private static void addToList(int size, List<String> slicedWords, StringBuilder slicedWord) {
		if (slicedWord.length() == size) {
			slicedWords.add(slicedWord.toString());
			slicedWord.deleteCharAt(0);
		}
	}

	private static boolean isDuplicatedNickname(String word) {
		InNickName duplicative = new InNickName(word);
		if (duplicateWordRepository.get(duplicative) > DUPLICATE_LIMIT) {
			return true;
		}
		return false;
	}

	private static void addDuplicativeWord(String word) {
		InNickName duplicative = new InNickName(word);
		Integer emergedCount = duplicateWordRepository.getOrDefault(duplicative, 0);
		duplicateWordRepository.put(
			duplicative,
			emergedCount + 1
		);
	}

}
