package onboarding.problem4.application.treefrog;

import java.util.Map;

import onboarding.problem4.application.Dictionary;
import onboarding.problem4.application.Translator;

public class TreeFrogTranslator implements Translator {

	private final Dictionary dictionary;

	public TreeFrogTranslator(Dictionary dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public String translate(String before) {
		char[] chars = before.toCharArray();

		StringBuilder answerString = new StringBuilder();
		for (char letter : chars) {
			answerString.append(convertToTreeFrogLetter(letter));
		}

		return answerString.toString();
	}

	private Character convertToTreeFrogLetter(char split) {
		Map<Character, Character> treeFrogDictionary = dictionary.getDictionary();

		return treeFrogDictionary.getOrDefault(split, split); //사전에 없는 경우는 그대로 반환
	}

}
