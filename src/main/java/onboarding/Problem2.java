package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        StringBuilder sb = new StringBuilder(cryptogram);

        while (hasConsecutiveWord(sb)) {
            sb = removeConsecutiveWord(sb);
        }
        answer = sb.toString();

        return answer;
    }

    public static boolean hasConsecutiveWord(String cryptogram) {
        for (int i = 0; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static StringBuilder removeConsecutiveWord(StringBuilder cryptogram) {
        StringBuilder sb = new StringBuilder();
        int temp;

        for (int i = 0; i < cryptogram.length(); i++) {
            temp = findConsecutiveWordEndIndex(cryptogram, i);
            if (temp == i) {
                sb.append(cryptogram.charAt(i));
                continue;
            }
            i = temp;
        }
        return sb;
    }

    public static int findConsecutiveWordEndIndex(StringBuilder cryptogram, int start) {
        int end = start;

        for (int i = start; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                end++;
                continue;
            }
            break;
        }
        return end;
    }
}
