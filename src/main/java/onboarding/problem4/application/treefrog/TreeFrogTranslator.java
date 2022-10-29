package onboarding.problem4.application.treefrog;

import onboarding.problem4.application.Dictionary;
import onboarding.problem4.application.Translator;

public class TreeFrogTranslator implements Translator {

	private final Dictionary dictionary;

	public TreeFrogTranslator(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
}
