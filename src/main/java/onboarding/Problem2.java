package onboarding;

public class Problem2 {

    static StringBuilder beforeRemoval = new StringBuilder();

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    static StringBuilder checkOverlap() {
        StringBuilder afterRemoval = new StringBuilder();

        for (int index = 0; index < beforeRemoval.length() - 1; index++) {
            char nowChar = beforeRemoval.charAt(index);
            char nextChar = beforeRemoval.charAt(index + 1);

            index = skipOverlap(nowChar, nextChar, index);
            afterRemoval.append(beforeRemoval.charAt(index));
        }

        return afterRemoval;
    }

    static int skipOverlap(char nowChar, char nextChar, int index) {
        if (nowChar == nextChar) {
            index = findOverlapEndPoint(nowChar, index + 1);
        }

        return index;
    }

    static int findOverlapEndPoint(char nowChar, int index) {
        char nextChar = beforeRemoval.charAt(index);
        int length = beforeRemoval.length() - 1;

        while (index < length && nowChar == nextChar) {
            nextChar = beforeRemoval.charAt(++index);
        }

        return index;
    }
}
