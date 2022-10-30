package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer = decode(cryptogram);
        return answer;
    }

    public static String decode(String cryptogram) {
        int i = 0;
        int len = cryptogram.length();
        StringBuilder decrypted = new StringBuilder(len);

        while (i < len) {
            deleteContinuousDuplicated(decrypted, cryptogram.charAt(i));
            ++i;
        }
        return decrypted.toString();
    }

    public static void deleteContinuousDuplicated(StringBuilder decrypted, char ch) {
        int len = decrypted.length();

        if (len != 0 && decrypted.charAt(len - 1) == ch) {
            decrypted.deleteCharAt(len - 1);
        }
        else {
            decrypted.append(ch);
        }
    }
}
