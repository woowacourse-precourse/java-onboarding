package onboarding;

public class Problem2 {
    public static final int NO_DUPLICATE = -1;
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (true) {
            int duplicatesIndex = getDuplicatesIndex(answer);
            if (duplicatesIndex == NO_DUPLICATE) return answer;
            answer = removeDuplicates(answer, duplicatesIndex);
        }
    }

    public static String removeDuplicates(String str, int index) {
        String afterStr = str.substring(0, index) + str.substring(index + 2);
        return afterStr;
    }

    public static int getDuplicatesIndex(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) return i;
        }
        return NO_DUPLICATE;
    }
}