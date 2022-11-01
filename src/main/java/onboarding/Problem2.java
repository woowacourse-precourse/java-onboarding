package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decodeCryptogram(cryptogram);
    }

    private static String decodeCryptogram(String cryptogram) {
        StringBuilder cryptogramBuilder = new StringBuilder(cryptogram);
        int cryptogramLength = 0;
        while (checkDecodeNotFinished(cryptogramBuilder, cryptogramLength)) {
            cryptogramLength = decodeCharacters(cryptogramBuilder);
        }

        return cryptogramBuilder.toString();
    }

    private static boolean checkDecodeNotFinished(StringBuilder cryptogramBuilder, int cryptogramLength) {

        return cryptogramLength != cryptogramBuilder.length();
    }

    private static int decodeCharacters(StringBuilder cryptogramBuilder) {
        int deletedCount = 0;
        int cryptogramLength = cryptogramBuilder.length();
        for (int currIndex = 0; currIndex < findCryptogramLength(cryptogramLength, deletedCount); currIndex++) {
            deletedCount = deleteRepeatedCharacters(cryptogramBuilder, deletedCount, currIndex);
        }
        return cryptogramLength;
    }

    private static int findCryptogramLength(int cryptogramLength, int deletedCount) {
        return cryptogramLength - 1 - deletedCount;
    }

    private static int deleteRepeatedCharacters(StringBuilder cryptogramBuilder,
                                                int deletedCount,
                                                int currIndex) {

        int endIndex = currIndex;
        while (checkRepeatedCharacter(cryptogramBuilder, currIndex, endIndex)) {
            endIndex++;
            deletedCount++;
        }

        if (checkDeletedMoreThanTwo(currIndex, endIndex)) {
            deleteString(cryptogramBuilder, currIndex, endIndex);
        }

        return deletedCount - 1;
    }

    private static boolean checkRepeatedCharacter(StringBuilder cryptogramBuilder,
                                                  int currIndex,
                                                  int endIndex) {

        return checkCryptogramRange(cryptogramBuilder, endIndex) &&
                checkSameCharacter(cryptogramBuilder, currIndex, endIndex);
    }

    private static boolean checkCryptogramRange(StringBuilder cryptogramBuilder, int endIndex) {
        return endIndex < cryptogramBuilder.length();
    }

    private static boolean checkSameCharacter(StringBuilder cryptogramBuilder,
                                              int currIndex,
                                              int endIndex) {

        return cryptogramBuilder.charAt(currIndex) == cryptogramBuilder.charAt(endIndex);
    }

    private static boolean checkDeletedMoreThanTwo(int currIndex, int endIndex) {
        return endIndex - currIndex >= 2;
    }

    private static void deleteString(StringBuilder cryptogramBuilder, int currIndex, int endIndex) {
        cryptogramBuilder.delete(currIndex, endIndex);
    }

}
