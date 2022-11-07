package onboarding.problem4;

public class WordConverter {

    private final CharacterConverter characterConverter;

    public WordConverter(CharacterConverter characterConverter) {
        this.characterConverter = characterConverter;
    }

    public String reverseWord(String word) {
        // 반대 단어로 변환 후 반환
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char currentCharacter = word.charAt(i);
            stringBuilder.append(characterConverter.reverseCharacter(currentCharacter));
        }

        return stringBuilder.toString();
    }

}
