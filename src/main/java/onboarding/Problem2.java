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

        private String decrypt() {
            String decrypted = encrypted;
            while (true) {
                String[] stringArray = decrypted.split("([a-z])\\1");
                if (stringArray.length == 1) {
                    break;
                }
                StringBuilder builder = new StringBuilder();
                for (String s : stringArray) {
                    builder.append(s);
                }
                decrypted = builder.toString();
            }
            return decrypted;
        }
    }

    public static String solution(String cryptogram) {
        var myCryptogram = new Cryptogram(cryptogram);
        if (!myCryptogram.IS_VALID) {
            return null;
        }
        return myCryptogram.decrypt();
    }
}
