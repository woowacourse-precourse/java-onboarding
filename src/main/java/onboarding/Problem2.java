package onboarding;


import java.util.Arrays;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = decryptString(cryptogram);

        return answer;
    }

    private static String decryptString(String cryptogram) {
        StringBuilder decryption = new StringBuilder(cryptogram);

        boolean[] eraser = new boolean[1010];
        boolean flag = true;
        int stringSize;

        while(flag){
            decryption = eraseDuplicateString(decryption, eraser);
            eraser = checkDuplicate(decryption.toString());

            flag = false;
            stringSize = decryption.length();
            for (int i = 0; i < stringSize; ++i) {
                if (eraser[i]) {
                    flag = true;
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
