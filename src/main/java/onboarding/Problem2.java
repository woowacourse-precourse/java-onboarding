package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        answer = decodingText(cryptogram);

        return answer;
    }

    public static String decodingText(String cryptogram) {
        while (true) {
            int start = findSame(cryptogram);
            int end = start;

            if (start == -1) {
                return cryptogram;
            }

            for (end = start + 1; end < cryptogram.length(); end++) {
                if (cryptogram.charAt(start) != cryptogram.charAt(end)) {
                    break;
                }
            }

            cryptogram = cryptogram.substring(0, start) + cryptogram.substring(end, cryptogram.length());
        }
    }

    public static int findSame(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return i;
            }
        }
        return -1;
    }
}
