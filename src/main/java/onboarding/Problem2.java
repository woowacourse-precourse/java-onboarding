package onboarding;

import problem2.Deleter;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder decodedCrypto = new StringBuilder(cryptogram);
        int cryptoLength = decodedCrypto.length();
        int deletedLength = 0;
        Deleter deleter = new Deleter(decodedCrypto, cryptoLength);

        while ((deletedLength = deleter.getNumberOfDeleted()) != 0)
            cryptoLength -= deletedLength;

        return decodedCrypto.toString();
    }
}
