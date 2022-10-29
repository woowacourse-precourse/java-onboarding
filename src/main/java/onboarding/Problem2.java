package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        StringBuilder cryptogramBuilder = new StringBuilder(cryptogram);

        boolean checkConversion = false;
        while (!checkConversion) {
            checkConversion = decode(cryptogramBuilder);
        }
        return "";
    }

    public static boolean decode(StringBuilder encodedCode) {
        int count = 1;
        for (int i = 1; i < encodedCode.length(); i++) {

        }
        return false;
    }
}
