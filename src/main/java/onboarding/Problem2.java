package onboarding;


import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decryptString(cryptogram);

        return answer;
    }

    private static String decryptString(String cryptogram) {
        StringBuilder decryption = new StringBuilder(cryptogram);

        boolean[] toErase = new boolean[1010];
        boolean isDuplicate = true;
        int stringSize;

        while(isDuplicate){
            decryption = eraseDuplicateString(decryption, toErase);
            toErase = checkDuplicate(decryption.toString());

            isDuplicate = false;
            stringSize = decryption.length();
            for (int i = 0; i < stringSize; ++i) {
                if (toErase[i]) {
                    isDuplicate = true;
                }
            }
        }
        return decryption.toString();
    }

    private static StringBuilder eraseDuplicateString(StringBuilder str, boolean[] toErase) {
        StringBuilder nonDuplicateString = new StringBuilder();
        int strSize = str.length();

        for (int i = 0; i < strSize; ++i) {
            if (toErase[i] == false) {
                nonDuplicateString.append(str.charAt(i));
            }
        }
        return nonDuplicateString;
    }

    private static boolean[] checkDuplicate(String str) {
        boolean[] isDuplicate = new boolean[1010];
        int stringSize = str.length();

        for (int i = 1; i < stringSize; ++i) {
            if(Character.compare(str.charAt(i - 1), str.charAt(i)) == 0){
                isDuplicate[i - 1] = true;
                isDuplicate[i] = true;
            }
        }
        return isDuplicate;
    }
}
