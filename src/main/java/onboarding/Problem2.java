package onboarding;

public class Problem2 {

    static StringBuilder beforeRemoval = new StringBuilder();

    public static String solution(String cryptogram) {
        return repeatRemoveOverlap(cryptogram);
    }

    static String repeatRemoveOverlap(String cryptogram) {
        beforeRemoval = new StringBuilder();
        beforeRemoval.append(cryptogram).append(' ');

        int nowLength = beforeRemoval.length();
        int nextLength = 0;

        while (nowLength != nextLength) {
            nowLength = nextLength;

            beforeRemoval = checkOverlap();
            beforeRemoval.append(' ');

            nextLength = beforeRemoval.length();
        }

        String answer = beforeRemoval.toString();

        return answer.trim();
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