package onboarding;

public class Problem2 {
    private static class Cryptogram {
        private final String encrypted;
        private final boolean IS_VALID;

        private Cryptogram(String encrypted) {
            this.encrypted = encrypted;
            this.IS_VALID = validate();
        }

        private boolean validate() {
            if (encrypted == null || encrypted.length() < 1 || 1000 < encrypted.length()) {
                return false;
            }
            boolean isLowerCase = true;
            for (int i = 0; isLowerCase && i < encrypted.length(); i++) {
                char c = encrypted.charAt(i);
                isLowerCase = Character.isLowerCase(c);
            }
            return isLowerCase;
        }

        // TODO: decrypt()
    }

    public static String solution(String cryptogram) {
        var myCryptogram = new Cryptogram(cryptogram);
        if (!myCryptogram.IS_VALID) {
            return null;
        }
        return myCryptogram.encrypted;
    }
}
