package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder cryptoBuilder = new StringBuilder(cryptogram);
        boolean loop = true;
        int continueIdx = 0;

        while(loop) {
            loop = false;
            for (int i = continueIdx; i < cryptoBuilder.length() - 1; i++) {
                if (cryptoBuilder.charAt(i) == cryptoBuilder.charAt(i + 1)) {
                    cryptoBuilder.delete(i, i + 2);
                    loop = true;
                    if (continueIdx > 0)
                        continueIdx -= 1;
                }
            }
        }

        return cryptoBuilder.toString();
    }
}
