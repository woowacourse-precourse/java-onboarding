package onboarding.problem4;

import java.util.ArrayList;
import java.util.List;

public class Frog {

    private static final int MAX_LENGTH = 1000;
    private static final int MIN_LENGTH = 1;

    private static Frog INSTANCE;

    private final List<String> reversedLowerAlphabetArray = new ArrayList<>();
    private final List<String> reversedHigherAlphabetArray = new ArrayList<>();

    private Frog() {
        for (int i = 0; i < 26; i++) {
            reversedLowerAlphabetArray.add(String.valueOf((char) (122 - i)));
            reversedHigherAlphabetArray.add(String.valueOf((char) (90 - i)));
        }
    }

    public static Frog getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Frog();
        }
        return INSTANCE;
    }

    public String translate(String word) {

        validateWord(word);

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            stringBuilder.append(reverse(c));
        }
        return stringBuilder.toString();
    }

    private void validateWord(String word) {
        if (word.length() < MIN_LENGTH || word.length() > MAX_LENGTH) {
            throw new RuntimeException("1 이상 1000 이하의 값만 입력 가능합니다.");
        }
    }

    private String reverse(char c) {
        if (isLowerAlphabet(c)) {
            int index = c - 97;
            return reversedLowerAlphabetArray.get(index);
        }
        if (isHigherAlphabet(c)) {
            int index = c - 65;
            return reversedHigherAlphabetArray.get(index);
        }
        return String.valueOf(c);
    }

    private boolean isLowerAlphabet(char c) {
        return (c >= 97) && (c <= 122);
    }

    private boolean isHigherAlphabet(char c) {
        return (c >= 65) && (c <= 90);
    }
}
