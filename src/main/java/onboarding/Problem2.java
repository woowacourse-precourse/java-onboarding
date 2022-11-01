package onboarding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String cryptogram) {

        String result = deleteDuplicatation(cryptogram);

        return result;
    }

    public static String deleteDuplicatation(String cryptogram) {
        StringBuilder str = new StringBuilder(cryptogram);

        for(int i =0, j=1; j<str.length();i++,j++) {
            if(str.charAt(i) == str.charAt(j)) {
                str.deleteCharAt(i);
                str.deleteCharAt(i);
                i=-1;
                j=0;
            }
        }

        String result = str.toString();

        return result;
    }
}
