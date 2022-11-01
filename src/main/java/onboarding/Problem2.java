package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    private static Queue<Character> words = new LinkedList<>();

    public static String solution(String cryptogram) {
        words.clear();
        initializeWords(cryptogram);
        int count = 1;

        while (count != 0) {
            count = deleteDuplicateInWords();
        }

        String answer = wordsToString();
        return answer;
    }

    private static void initializeWords(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            char nowChar = cryptogram.charAt(i);
            words.offer(nowChar);
        }
    }

    private static int deleteDuplicateInWords() {
        int count = 0;
        int size = words.size();

        if (!isCheckNeeded(size)) {
            return count;
        }

        char nowChar;
        char recentDuplicateChar = ' ';

        for (int i = 0; i < size; i++) {
            nowChar = words.poll();

            int update = checkNowChar(nowChar, recentDuplicateChar, size, i);
            count = updateCount(update, count);
            recentDuplicateChar = updateRecentDuplicateChar(recentDuplicateChar, nowChar, update);
        }

        return count;
    }

    private static String wordsToString() {
        StringBuilder sb = new StringBuilder();
        while (!words.isEmpty()) {
            sb.append(words.poll());
        }
        return sb.toString();
    }

    private static Boolean isCheckNeeded(int size) {
        if (size <= 1) {
            return false;
        }
        return true;
    }

    private static int checkNowChar(char nowChar, char recentDuplicateChar, int size, int currentIdx) {
        if (isSameWithRecentDuplicateChar(nowChar, recentDuplicateChar)) {
            return 1;
        }

        int nextIdx = currentIdx + 1;
        if (!isNextCharAvailable(size, nextIdx)) {
            putNowCharToQueue(nowChar);
            return 0;
        }

        if (isSameWithNextChar(nowChar, nextIdx)) {
            return 1;
        }

        putNowCharToQueue(nowChar);
        return 0;
    }

    private static int updateCount(int update, int count) {
        count += update;
        return count;
    }

    private static char updateRecentDuplicateChar(char recentDuplicateChar, char nowChar, int update) {
        if (update == 0) {
            recentDuplicateChar = ' ';
        }

        if (update == 1) {
            recentDuplicateChar = nowChar;
        }

        return recentDuplicateChar;
    }

    private static Boolean isSameWithRecentDuplicateChar(char nowChar, char recentDuplicateChar) {
        if (recentDuplicateChar == nowChar) {
            return true;
        }
        return false;
    }

    private static Boolean isNextCharAvailable(int size, int nextIdx) {
        if (nextIdx == size) {
            return false;
        }
        return true;
    }

    private static Boolean isSameWithNextChar(char nowChar, int nextIdx) {
        char nextChar = words.peek();
        if (nextChar == nowChar) {
            return true;
        }
        return false;
    }

    private static void putNowCharToQueue(char nowChar) {
        words.offer(nowChar);
    }
}
