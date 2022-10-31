package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder decode = new StringBuilder(cryptogram);
        boolean chk = true;

        while (chk) {
            chk = false;
            for (int i = 1; i < decode.length(); i++) {
                if (decode.charAt(i) == decode.charAt(i - 1)) {
                    decode.replace(i - 1, i + 1, "");
                    chk = true;
                    i--;
                }
            }
        }

        return decode.toString();
    }
}
