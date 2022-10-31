package onboarding;

import problem2.Deleter;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder decodedCrypto = new StringBuilder(cryptogram);

        delete(decodedCrypto, decodedCrypto.length());

        return decodedCrypto.toString();
    }

    private static void delete(StringBuilder decodedCrypto, int cryptoLength) {
        int deletedLength;
        Deleter deleter = new Deleter(decodedCrypto, cryptoLength);

        while ((deletedLength = deleter.getNumberOfDeleted()) != 0)
            cryptoLength -= deletedLength;
    }
}
