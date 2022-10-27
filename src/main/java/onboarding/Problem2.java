package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return getDecodedString(cryptogram);
    }

    public static String getDecodedString(String cryptogram) {
        StringBuilder sb = new StringBuilder(cryptogram);

        boolean isPresentDuplication = false;

        for (int i = 0; i < sb.length(); i++) {
            int duplicatedLastIndex = i;
            while (duplicatedLastIndex < sb.length() && sb.charAt(duplicatedLastIndex) == sb.charAt(i)) {
                duplicatedLastIndex++;
            }

            if (duplicatedLastIndex - i > 1) {
                sb.delete(i, duplicatedLastIndex);
                isPresentDuplication = true;
            }
        }

        if (isPresentDuplication) return getDecodedString(sb.toString());
        return sb.toString();
    }
}
