package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
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
}
