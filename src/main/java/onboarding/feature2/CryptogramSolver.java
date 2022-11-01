package onboarding.feature2;

import java.util.ArrayList;
import java.util.List;

public class CryptogramSolver {
    public static String analyzeCryptogram(String cryptogram) {
        if (cryptogram.length() < 2) {
            return cryptogram;
        }
        char[] previousCharsOfCryptogram = cryptogram.toCharArray();
        List<Character> laterCharsOfCryptogram = new ArrayList<>();
        compareChars(previousCharsOfCryptogram, laterCharsOfCryptogram);

        // Compare the last character of cryptogram with the second last character
        int lastIndex = previousCharsOfCryptogram.length - 1;
        if (previousCharsOfCryptogram[lastIndex] != previousCharsOfCryptogram[lastIndex - 1]) {
            laterCharsOfCryptogram.add(previousCharsOfCryptogram[lastIndex]);
        }

        String newCryptogram = CharactersCombiner.charsToString(laterCharsOfCryptogram);
        if (!cryptogram.equals(newCryptogram)) {
            return analyzeCryptogram(newCryptogram);
        }
        return newCryptogram;
    }

    public static void compareChars(char[] previousCharsOfWord, List<Character> laterCharsOfWord) {
        for (int i = 1; i < previousCharsOfWord.length; i++) {
            if (previousCharsOfWord[i - 1] != previousCharsOfWord[i]) {
                laterCharsOfWord.add(previousCharsOfWord[i - 1]);
                continue;
            }
            // While adjacent elements are duplicate, keep increasing the index
            while (i < previousCharsOfWord.length && previousCharsOfWord[i - 1] == previousCharsOfWord[i]) {
                i++;
            }
        }
    }
}
