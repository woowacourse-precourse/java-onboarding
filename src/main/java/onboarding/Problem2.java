package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        while (isEncrypted(cryptogram)) {
            if (cryptogram.length() == 0) {
                break;
            }
            cryptogram = decryption(cryptogram);
        }
        return cryptogram;
    }

    public static String decryption(String cryptogram) {

        if (cryptogram.length() == 2) {
            cryptogram = "";
        } else {

            int startConsecutive = 0;
            int endConsecutive = cryptogram.length() - 1;

            for (int i = 1; i < cryptogram.length(); i++) {

                if (cryptogram.charAt(i - 1) == cryptogram.charAt(i)) {
                    startConsecutive = i - 1;
                    char currentChar = cryptogram.charAt(i);

                    for (int j = i - 1; j < cryptogram.length(); j++) {
                        if (cryptogram.charAt(j) != currentChar) {
                            endConsecutive = j - 1;
                            break;
                        }
                    }
                }
            }

            cryptogram = cryptogram.substring(0, startConsecutive) + cryptogram.substring(endConsecutive + 1);
        }

        return cryptogram;
    }

    public static boolean isEncrypted(String cryptogram) {

        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i - 1)) {
                return true;
            }
        }
        return false;
    }

}
