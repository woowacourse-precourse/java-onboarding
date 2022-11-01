package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;

        while (true) {
            String tmp;
            tmp = removeDuplicates(answer);
            if (tmp == null) {
                break;
            }
            answer = tmp;
        }

        return answer;
    }

    private static String removeDuplicates(String cryptogram) {
        if (cryptogram.length() == 0) {
            return null;
        }

        String answer = "";
        char[] charArray = cryptogram.toCharArray();
        int sequenceCount = 0;

        char tmp = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            if (tmp == charArray[i]) {
                ++sequenceCount;
            } else {
                if (sequenceCount == 0) {
                    answer += tmp;
                } else {
                    sequenceCount = 0;
                }
                if (i == charArray.length - 1) {
                    answer += charArray[i];
                }
            }
            tmp = charArray[i];
        }

        if (answer.equals(cryptogram)) {
            return null;
        }
        return answer;
    }
}
