package onboarding.problem4;

public class AlphabetChanger {
	private final Character alphabetSeparator = 'Z';
	private final int trueChangeNumber = 'z' + 'a';
	private final int falseChangeNumber = 'Z' + 'A';

	public Character change(char word) {
		if (word > alphabetSeparator){
			return (char)(trueChangeNumber - word);
		}
		return (char)(falseChangeNumber - word);
	}
}
