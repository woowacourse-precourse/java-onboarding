package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String beforeCryptogram = cryptogram;
        cryptogram = removeDuplicate(cryptogram);

        if (beforeCryptogram.equals(cryptogram)) {
            return cryptogram;
        }

        return solution(cryptogram);
    }

    private static String removeDuplicate(String cryptogram) {
        StringBuilder result = new StringBuilder();
        char[] chars = cryptogram.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            if (chars[i-1] != chars[i]) {
                result.append(chars[i-1]);
                continue;
            }
            i++;
        }
        if (result.length() != 0) {
            result.append(chars[chars.length - 1]);
        }

        return result.toString();
    }

}
