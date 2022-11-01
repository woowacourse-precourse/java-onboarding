package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return removeDuplicateString(cryptogram);
    }

    public static String removeDuplicateString(String cryptogram) {
        StringBuilder decryption = new StringBuilder();
        int length = cryptogram.length();

        for (int i=1; i<length; i++) {
            if (cryptogram.charAt(i-1) != cryptogram.charAt(i)) {
                decryption.append(cryptogram.charAt(i-1));
            }
            if (cryptogram.charAt(i-1) == cryptogram.charAt(i)) i++;
        }
        if (cryptogram.charAt(length-2) != cryptogram.charAt(length-1))
            decryption.append(cryptogram.charAt(length-1));

        return decryption.toString();
    }
}
