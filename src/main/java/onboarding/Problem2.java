package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        assert (cryptogram != null);
        assert (cryptogram.length() >= 1 && cryptogram.length() <= 1000);
        assert (isComposedOnlyOfLowercaseAlphabets(cryptogram));

        int cryptogramLength = cryptogram.length();
        char[] nonDuplicateCharStack = new char[cryptogramLength];

        int pointer = 0;
        int top = 0;

        while (pointer < cryptogramLength) {
            if (top == 0) {
                nonDuplicateCharStack[top] = cryptogram.charAt(pointer);
                top++;
                pointer++;
                continue;
            }

            if (nonDuplicateCharStack[top - 1] != cryptogram.charAt(pointer)) {
                nonDuplicateCharStack[top] = cryptogram.charAt(pointer);
                top++;
                pointer++;
            } else {
                pointer++;
                while (pointer < cryptogramLength && nonDuplicateCharStack[top - 1] == cryptogram.charAt(pointer)) {
                    pointer++;
                }
                top--;
            }
        }

        char[] truncatedCryptogram = new char[top];
        System.arraycopy(nonDuplicateCharStack, 0, truncatedCryptogram, 0, truncatedCryptogram.length);

        return new String(truncatedCryptogram);
    }

    private static boolean isComposedOnlyOfLowercaseAlphabets(String string) {
        int stringLength = string.length();

        for (int i = 0; i < stringLength; i++) {
            if (!Character.isLowerCase(string.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
