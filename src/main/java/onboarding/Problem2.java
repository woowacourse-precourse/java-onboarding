package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        StringBuilder cryptogramBuilder = new StringBuilder(cryptogram);

        boolean checkConversion = true;
        while (checkConversion) {
            checkConversion = decode(cryptogramBuilder);
        }
        return "";
    }

    public static boolean decode(StringBuilder encodedCode) {
        int count = 1;
        boolean flag = false;
        for (int i = 1; i < encodedCode.length(); i++) {
            if (encodedCode.charAt(i) == encodedCode.charAt(i - 1)) {
                count++;
                continue;
            }
            if (encodedCode.charAt(i) != encodedCode.charAt(i - 1) && count >= 2) {
                flag = true;
                count = 1;
            }

        }
        return flag;
    }


    public static void main(String[] args) {
        String[] test = {"browoanoommnaon", "zyelleyz"};

        solution(test[0]);
    }
}
