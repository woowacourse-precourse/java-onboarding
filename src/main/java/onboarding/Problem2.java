package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        StringBuilder cryptoSB = new StringBuilder(cryptogram);

        while (true) {
            int cryptoLen = cryptoSB.length();

            for (int i = 0; i + 1 < cryptoSB.length(); i++) {
                int numOfDeleteChar = 0;

                if (cryptoSB.charAt(i) == cryptoSB.charAt(i + 1)) {
                    while (cryptoSB.charAt(i) == cryptoSB.charAt(i + 1)) {
                        cryptoSB.deleteCharAt(i + 1);

                        if (i + 1 == cryptoSB.length()) {
                            break;
                        }
                        numOfDeleteChar++;
                    }

                    cryptoSB.deleteCharAt(i);
                    i -= numOfDeleteChar;
                }
            }

            if (cryptoLen == cryptoSB.length()) {
                answer = cryptoSB.toString();
                break;
            }
        }

        return answer;
    }
}
