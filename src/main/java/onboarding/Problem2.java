package onboarding;

public class Problem2 {
    private static class Cryptogram {
        private final String encrypted;

        private Cryptogram(String encrypted) {
            this.encrypted = encrypted;
        }

        // TODO: validate()

        // TODO: decrypt()
    }

    public static String solution(String cryptogram) {
        var myCryptogram = new Cryptogram(cryptogram);
        return myCryptogram.encrypted;
    }
}
