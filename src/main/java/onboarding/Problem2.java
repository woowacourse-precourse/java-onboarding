package onboarding;

public class Problem2 {
    public static String[] removeDuplication(String cryptogram) {
        StringBuilder cipher = new StringBuilder(cryptogram);
        int count = 0;

        for (int i = 0; i < cipher.length() - 1; i++) {
            if (cipher.charAt(i) != cipher.charAt(i + 1))
                continue;

            int startIndex = i;
            int endIndex = i + 1;

            while (endIndex != cipher.length() &&
                    cipher.charAt(startIndex) == cipher.charAt(endIndex)) {
                endIndex++;
            }

            count = endIndex - startIndex;
            cipher.replace(startIndex, endIndex, "");
            i--;
        }

        return new String[]{cipher.toString(), String.valueOf(count)};
    }

    public static boolean removed(int countRemovedChars) {
        return countRemovedChars > 0;
    }

    public static String solution(String cryptogram) {
        while (true) {
            String[] result = removeDuplication(cryptogram);

            cryptogram = result[0];
            int countRemovedChars = Integer.parseInt(result[1]);

            if (!removed(countRemovedChars))
                break;
        }

        return cryptogram;
    }
}
