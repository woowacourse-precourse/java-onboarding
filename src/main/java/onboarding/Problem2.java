package onboarding;

public class Problem2 {
    public static String decryptionStep(String crypto) {
        for (int i = 0; i < crypto.length() - 1; i++) {
            if (crypto.charAt(i) == crypto.charAt(i + 1)) {
                String str = Character.toString(crypto.charAt(i));
                crypto = crypto.replace(str + str, "");
                i--;
            }
        }
        return crypto;
    }

    public static String solution(String cryptogram) {
        String currentString = cryptogram;

        while (true) {
            String nextString = decryptionStep(currentString);

            if (nextString.equals(currentString)) {
                break;
            }
            currentString = nextString;
        }
        return currentString;
    }
}
