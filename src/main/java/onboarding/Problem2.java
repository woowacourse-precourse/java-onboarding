package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String copyCryptogram = new String(cryptogram);

        while(isOverlap(copyCryptogram)) {
            copyCryptogram = translate(copyCryptogram);
        }

        return copyCryptogram;
    }

    private static boolean isOverlap(String cryptogram) {
        char[] chars = cryptogram.toCharArray();
        boolean status = false;

        for(int i=0; i<chars.length - 1; i++) {
            if(chars[i] == chars[i+1]) {
                status = true;
                break;
            }
        }

        return status;
    }

    private static String translate(String cryptogram) {
        char[] chars = cryptogram.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<chars.length; i++) {
            if(sb.length() != 0) {
                if(sb.charAt(sb.length() - 1) == chars[i]) {
                    int lastOverlapIndex = i;
                    for(int k=i+1; k<chars.length; k++) {
                        if(chars[i] == chars[k]) lastOverlapIndex = k;
                        else break;
                    }
                    i = lastOverlapIndex;
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(chars[i]);
                }
            } else {
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
