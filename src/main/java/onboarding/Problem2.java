package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static int duplicatedLastIndex(String str, int startIndex) {
        char target = str.charAt(startIndex);
        for (int index = startIndex; index < str.length(); index++) {
            if (charEq(target, str.charAt(index))) {
                continue;
            }
            return index;
        }
        return -1;
    }

    private static boolean charEq(char target, char ch) {
        return target == ch;
    }

    private static String deduplication(String str, int startIndex, int lastIndex) {
        return str.substring(0, startIndex) + str.substring(lastIndex + 1);
    }
}
