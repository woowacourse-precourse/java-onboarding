package onboarding.support.problem2;

public class DecodeUtil {

    private static final int DUPLICATION_INTERVAL = 1;
    private final String decodedString;

    public DecodeUtil(String originalString) {
        this.decodedString = decode(originalString);
    }

    public static String decode(String cryptogram) {
        StringBuilder decodedString = new StringBuilder(cryptogram);

        for (int i = 0; i < cryptogram.length(); i++) {
            int duplicatedIndex = i + 1;
            duplicatedIndex = getDuplicatedIndex(cryptogram, i, duplicatedIndex);
            if (deleteDuplication(decodedString, i, duplicatedIndex)) {
                break;
            }
        }

        if (isNotDecoded(cryptogram, decodedString.toString())) {
            return cryptogram;
        }

        return decode(decodedString.toString());
    }

    private static boolean deleteDuplication(StringBuilder decodedString, int baseIndex, int duplicatedIndex) {
        if (duplicatedIndex - baseIndex > DUPLICATION_INTERVAL) {
            decodedString.delete(baseIndex, duplicatedIndex);
            return true;
        }
        return false;
    }

    private static int getDuplicatedIndex(String originalString, int baseIndex, int duplicatedIndex) {
        while (isDuplicated(originalString, baseIndex, duplicatedIndex)) {
            duplicatedIndex++;
        }
        return duplicatedIndex;
    }

    private static boolean isDuplicated(String originalString, int baseIndex, int duplicatedIndex) {
        return duplicatedIndex < originalString.length()
                && originalString.charAt(baseIndex) == originalString.charAt(duplicatedIndex);
    }

    private static boolean isNotDecoded(String originalString, String decodedString) {
        return originalString.equals(decodedString);
    }

    public String getDecodedString() {
        return decodedString;
    }
}
