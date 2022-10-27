package onboarding.support.problem2;

public class DecodeUtil {

    private static int getDuplicatedIndex(StringBuilder originalString, int i, int duplicatedIndex) {
        while (duplicatedIndex < originalString.length() && originalString.charAt(i) == originalString.charAt(duplicatedIndex)) {
            duplicatedIndex++;
        }
        return duplicatedIndex;
    }
}
