package onboarding.support.problem2;

public class DecodeUtil {

    private static final int DUPLICATION_INTERVAL = 1;

    private static boolean deleteDuplication(StringBuilder decodedString, int i, int duplicatedIndex) {
        if (duplicatedIndex - i > DUPLICATION_INTERVAL) {
            decodedString.delete(i, duplicatedIndex);
            return true;
        }
        return false;
    }

    private static int getDuplicatedIndex(StringBuilder originalString, int i, int duplicatedIndex) {
        while (duplicatedIndex < originalString.length() && originalString.charAt(i) == originalString.charAt(duplicatedIndex)) {
            duplicatedIndex++;
        }
        return duplicatedIndex;
    }
}
