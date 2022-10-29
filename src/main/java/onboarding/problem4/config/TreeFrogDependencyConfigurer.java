package onboarding.problem4.config;

import onboarding.problem4.application.Dictionary;
import onboarding.problem4.application.Translator;
import onboarding.problem4.application.treefrog.TreeFrogDictionary;
import onboarding.problem4.application.treefrog.TreeFrogTranslator;

public class TreeFrogDependencyConfigurer {

	private static Translator translator;
	private static Dictionary dictionary;

	public Translator treeFrogTranslator() {
		if (translator == null) {
			translator = new TreeFrogTranslator(treeFrogDictionary());
		}

		return translator;
	}

	public Dictionary treeFrogDictionary() {
		if (dictionary == null) {
			dictionary = new TreeFrogDictionary();
		}

		return dictionary;
	}
}
