package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decoding(cryptogram);
    }

    private static String decoding(String cryptogram) {
        int currentLength = cryptogram.length();
        String decodedPassword = removeOverlapString(cryptogram);

        if (decodedPassword.length() != currentLength) {
            return decoding(decodedPassword);
        }
        return decodedPassword;
    }

    public static String removeOverlapString(String password) {
        StringBuilder stringBuilder = new StringBuilder(password);

        for (int i = 0; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(i + 1)) {
                stringBuilder.deleteCharAt(i + 1);
                stringBuilder.deleteCharAt(i);
            }
        }

        return stringBuilder.toString();
    }
}
