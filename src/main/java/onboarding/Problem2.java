package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = makeResult(cryptogram);
        return answer;
    }

    private static String makeResult(String cryptogram) {
        int resultLength = cryptogram.length() + 1;
        while (cryptogram.length() != resultLength) {
            resultLength = cryptogram.length();
            cryptogram = reduceCryptogram(cryptogram);
        }
        return cryptogram;
    }

    private static String reduceCryptogram(String cryptogram) {
        String cloneCryptogram = "";
        for (int i = 0; i < cryptogram.length(); i++) {
            if (i != 0 && cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                continue;
            } else if (i != cryptogram.length() - 1 && cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                continue;
            }
            cloneCryptogram += cryptogram.charAt(i);
        }
        return cloneCryptogram;
    }
}
