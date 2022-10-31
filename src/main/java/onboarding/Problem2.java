package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem2 {
    public static String delSameChar(String str) {
        String result = new String();
        for(int i=0, j=i+1; i<str.length(); i++) {
            while(j < str.length() && str.charAt(i)==str.charAt(j)) j++;
            if(i+1==j) result += str.substring(i, j);
            else i = j-1;
        }
        return result;
    }

    public static String solution(String cryptogram) {
        int len = -1;
        while(len!=cryptogram.length()) {
            len = cryptogram.length();
            cryptogram = delSameChar(cryptogram);
        }
        return cryptogram;
    }
}
