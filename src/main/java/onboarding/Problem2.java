package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int length = 0;
        do {
            length = cryptogram.length();
            cryptogram = deleteDuplicate(cryptogram);
        } while (length != cryptogram.length());

        return cryptogram;
    }

    private static String deleteDuplicate(String cryptogram) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = cryptogram.length();
        for (int i = 0; i < length; i++) {
            char currentCharacter = cryptogram.charAt(i);

            if (i == 0 && currentCharacter != cryptogram.charAt(i + 1)) {
                stringBuilder.append(currentCharacter);
                continue;
            } else if (i == 0 && currentCharacter == cryptogram.charAt(i + 1)) {
                continue;
            }

            if (i == length - 1 && currentCharacter != cryptogram.charAt(i - 1)) {
                stringBuilder.append(currentCharacter);
                continue;
            } else if (i == length - 1 && currentCharacter == cryptogram.charAt(i - 1)) {
                continue;
            }

            char previousCharacter = cryptogram.charAt(i - 1);
            char nextCharacter = cryptogram.charAt(i + 1);
            if (currentCharacter != nextCharacter
                    && previousCharacter != currentCharacter) {
                stringBuilder.append(currentCharacter);
            }
        }

        return stringBuilder.toString();
    }
}
