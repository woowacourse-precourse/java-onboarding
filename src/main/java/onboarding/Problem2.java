package onboarding;

public class Problem2 {

    static char[] separateString(String cryptogram) {
        char[] cryptoChar = cryptogram.toCharArray();

        return cryptoChar;
    }

    static Boolean checkDuplication(char[] separatedCrypto) {
        for (int i = 0; i < separatedCrypto.length; i++) {
            if (separatedCrypto[i] == separatedCrypto[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        char[] separatedCrypto = separateString(cryptogram);

        return answer;
    }
}
