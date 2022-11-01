package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decoder(cryptogram);
    }

    private static String decoder(String cryptogram) {
        String str = "";
        while (lengthNotEq(str, cryptogram)) {
            str = cryptogram;
            cryptogram = checkDuplicate(cryptogram);
        }
        return cryptogram;
    }

    private static boolean lengthNotEq(String str, String target) {
        return str.length() != target.length();
    }

    private static String checkDuplicate(String str) {
        for (int index = 0; index < str.length(); index++) {
            int lastIndex = duplicatedLastIndex(str, index);
            if (index < lastIndex) {
                str = deduplication(str, index, lastIndex);
                index--;
            }
        }
        return str;
    }

    private static int duplicatedLastIndex(String str, int startIndex) {
        char target = str.charAt(startIndex);
        for (int index = startIndex; index < str.length(); index++) {
            if (charEq(target, str.charAt(index))) {
                continue;
            }
            return index - 1;
        }
        return str.length() - 1;
    }

    private static boolean charEq(char target, char ch) {
        return target == ch;
    }

    private static String deduplication(String str, int startIndex, int lastIndex) {
        return str.substring(0, startIndex) + str.substring(lastIndex + 1);
    }
}
