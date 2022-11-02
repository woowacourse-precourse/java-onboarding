package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String result = cryptogram + " ";
        while (true) {
            String after = deduplicate(result);
            if (result.equals(after)) {
                break;
            }
            result = after;
        }

        return result.trim();
    }

    private static String deduplicate(String cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            char c1 = cryptogram.charAt(i);
            char c2 = cryptogram.charAt(i + 1);
            if (c1 != c2) continue;

            for (int j = i + 1; j < cryptogram.length(); j++) {
                char c3 = cryptogram.charAt(j);
                if (c1 != c3) {
                    String subString = String.valueOf(c1).repeat(j - i);
                    cryptogram = cryptogram.replace(subString, "");
                    break;
                }
            }
        }
        return cryptogram;
    }
}
