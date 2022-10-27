package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        boolean decoding = true;

        while (decoding) {
            decoding = false;

            for (int start = 0; start < answer.length() - 1; start++) {
                char currentChar = answer.charAt(start);

                int count = getDuplicatedCharCount(start, answer, currentChar);
                answer = removeDuplicateChar(answer, start, count);

                if (count > 0) {
                    decoding = true;
                    start--;
                }
            }
        }
        return answer;
    }

    private static int getDuplicatedCharCount(int start, String cryptogram, char currentChar) {
        int count = 0;
        for (int end = start + 1; end < cryptogram.length(); end++) {
            if (currentChar != cryptogram.charAt(end)) {
                break;
            }
            count = end - start + 1;
        }
        return count;
    }

    private static String removeDuplicateChar(String cryptogram, int start, int count) {
        return cryptogram.substring(0, start) + cryptogram.substring(start + count);
    }
}
