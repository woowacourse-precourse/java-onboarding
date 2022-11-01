package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = removeDuplicate(cryptogram);

        return answer;
    }


    private static String removeDuplicate(String word) {

        char recentChar = 0;
        boolean isRemoved = false;

        for (int i = 0; i < word.length(); i++) {
            if (i != 0 && recentChar == word.charAt(i)) {
                int start = i - 1;
                int end = findEndPoint(word, start);
                word = word.substring(0, start) + word.substring(end);
                isRemoved = true;
                break;
            }
            recentChar = word.charAt(i);
        }

        if (isRemoved) {
            word = removeDuplicate(word);
        }

        return word;
    }


    private static int findEndPoint(String word, int start) {
        int idx = start;
        char startChar = word.charAt(start);

        while (startChar == word.charAt(idx)) {
            if (++idx == word.length()) {
                break;
            }
        }

        return idx;
    }
}
