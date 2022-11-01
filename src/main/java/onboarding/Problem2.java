package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decodeCryptogram(cryptogram);
    }

    private static String decodeCryptogram(String cryptogram) {
        StringBuilder cryptogramBuilder = new StringBuilder(cryptogram);
        int cryptogramLength = decodeCharacters(cryptogramBuilder);


        return cryptogramBuilder.toString();
    }

    private static int decodeCharacters(StringBuilder cryptogramBuilder) {
        int deletedCount = 0;
        int cryptogramLength = cryptogramBuilder.length();
        for (int currIndex = 0; currIndex < findCryptogramLength(cryptogramLength, deletedCount); currIndex++) {
            deletedCount = deleteRepeatedCharacters();
        }
        return cryptogramLength;
    }

    private static int findCryptogramLength(int cryptogramLength, int deletedCount) {
        return cryptogramLength - 1 - deletedCount;
    }

}
