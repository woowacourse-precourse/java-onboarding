package onboarding.problem4;

public class Frog {

	private final FrogDictionary frogDictionary;

	public Frog(FrogDictionary frogDictionary) {
		this.frogDictionary = frogDictionary;
	}

	public String convert(String word) {
		StringBuilder stringBuilder = new StringBuilder();
		for (char character : word.toCharArray()) {
			stringBuilder.append(convertCharacter(character));
		}
		return stringBuilder.toString();
	}

	private Character convertCharacter(char character) {
		return frogDictionary.find(character)
			.orElse(character);
	}
}
