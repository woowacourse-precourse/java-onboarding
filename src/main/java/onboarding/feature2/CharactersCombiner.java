package onboarding.feature2;

import java.util.List;

public class CharactersCombiner {
    public static String charsToString(List<Character> characters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character singleChar : characters) {
            stringBuilder.append(singleChar);
        }
        String combinedChars = stringBuilder.toString();
        return combinedChars;
    }
}
