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
        for (int index = 0; index < str.length() - 1; index++) {
            if (str.charAt(index) == str.charAt(index + 1)) return index;
        }
        return NO_DUPLICATE;
    }
}