package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decode(cryptogram);
        String prev = cryptogram;
        while (!answer.equals("") && !answer.equals(prev)) {
            prev = answer;
            answer = decode(answer);
        }
        return answer;
    }

    public static String decode(String cryptogram) {
        StringBuilder decrypted = new StringBuilder(cryptogram.length());
        int len = cryptogram.length();
        boolean isSequence = false;
        for (int i = 0; i < len; ++i) {
            int decryLen = decrypted.length();
            char ch = cryptogram.charAt(i);
            if (decryLen != 0 && decrypted.charAt(decryLen - 1) == ch) {
                isSequence = true;
                continue;
            }
            if (isSequence) {
                decrypted.deleteCharAt(decryLen - 1);
                --decryLen;
                isSequence = false;
            }
            decrypted.append(ch);
        }
        if (isSequence) {
            decrypted.deleteCharAt(decrypted.length() - 1);
        }
        return decrypted.toString();
    }


}
