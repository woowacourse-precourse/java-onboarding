package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        var myCryptogram = new Cryptogram(cryptogram);
        if (!myCryptogram.validate()) {
            throw new IllegalArgumentException();
        }
        return myCryptogram.decrypt();
    }
}

class Cryptogram {
    private final String encrypted;

    Cryptogram(String encrypted) {
        this.encrypted = encrypted;
    }

    boolean validate() {
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

    String decrypt() {
        String decrypted = encrypted;
        while (true) {
            String[] stringArray = decrypted.split("([a-z])\\1{1,}");
            if (stringArray.length == 1) {
                decrypted = stringArray[0];
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
