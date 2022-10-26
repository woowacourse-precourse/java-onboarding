package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        String answer = cryptogram;

        while (true) {
            String extractedString = extract(answer);
            if (extractedString.equals(answer)) break;
            answer = extractedString;
        }
        return answer;
    }

    private static String extract(String cryptogram) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cryptogram.length(); i++) {
            if (isDuplicated(cryptogram,i)) {
                continue;
            }
            if (isDuplicated(cryptogram, i)) {
                continue;
            }
            sb.append(cryptogram.charAt(i));
        }
        return sb.toString();
    }

    private static boolean isDuplicated(String cryptogram, int i) {
        if (i != 0 && cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
            return true;
        }
        if (i != cryptogram.length() - 1 && cryptogram.charAt(i + 1) == cryptogram.charAt(i)) {
            return true;
        }
        return false;
    }

}
