package onboarding;

import onboarding.feature4.AlphabetValidator;
import onboarding.feature4.Encryption;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        List<Character> wordsIntoLetters = new ArrayList<>();
        for (char letter : word.toCharArray()) {
            wordsIntoLetters.add(letter);
        }

        List<Character> lettersEncrypted = Encryption.encryptLetters(wordsIntoLetters);
        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : lettersEncrypted) {
            stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
