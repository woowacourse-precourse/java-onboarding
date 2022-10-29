package onboarding;

import java.util.HashMap;

public class Problem4 {
    static class ConvertAlphabet {
        HashMap<Character, Character> alphabet = new HashMap<Character, Character>();

        public ConvertAlphabet() {
            char upperAlphabetSerial = 65;
            char lowerAlphabetSerial = 97;

            for (int i = 0; i < 26; i++) {
                alphabet.put(upperAlphabetSerial, (char) (90 - i));
                alphabet.put(lowerAlphabetSerial, (char) (122 - i));

                upperAlphabetSerial++;
                lowerAlphabetSerial++;
            }
        }
    }

    static class StringBuilderWords {
        StringBuilder stringBuilder;
        String answer;
        int stringLength;

        StringBuilderWords(String word) {
            this.stringBuilder = new StringBuilder(word);
            this.answer = "";
            stringLength = stringBuilder.length();
        }

        private String getConvertWord() {
            for (int i = 0; i < stringLength; i++) {
                char isAlpha = stringBuilder.charAt(i);
                checkingAlphabet(i, isAlpha, new ConvertAlphabet());
            }

            return answer;
        }

        private void checkingAlphabet(int idx, char isAlpha, ConvertAlphabet convertAlphabet) {
            if (isAlpha >='A' && isAlpha <= 'Z' ||
                    isAlpha >= 'a' && isAlpha <= 'z') {
                char character =
                        convertAlphabet.alphabet.get(stringBuilder.charAt(idx));
                answer += character;
            } else {
                answer += stringBuilder.charAt(idx);
            }
        }
    }

    public static String solution(String word) {
        StringBuilderWords stringBuilderWords = new StringBuilderWords(word);

        return stringBuilderWords.getConvertWord();
    }
}
