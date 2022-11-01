package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true) {
            String removedCrypto = removeDuplicatedChar(cryptogram);
            if (cryptogram.equals(removedCrypto))
                break;
            cryptogram = removedCrypto;
        }
        return cryptogram;
    }

    private static boolean[] checkDuplicatedChar(String cryptogram) {
        boolean[] duplicated = new boolean[cryptogram.length()];

        for (int i = 1; i < cryptogram.length(); i++) {
            char curChar = cryptogram.charAt(i);
            char prevChar = cryptogram.charAt(i - 1);
            if (curChar == prevChar) {
                duplicated[i - 1] = true;
                duplicated[i] = true;
            }
        }
        return duplicated;
    }

    private static String removeDuplicatedChar(String cryptogram) {
        StringBuilder sb = new StringBuilder();
        boolean[] duplicated = checkDuplicatedChar(cryptogram);
        for (int i = 0; i < cryptogram.length(); i++) {
            if (duplicated[i] == false)
                sb.append(cryptogram.charAt(i));
        }
        return sb.toString();
    }
}


