package onboarding;


import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        HashSet<String> hashSet = new HashSet<>();
        char[] toChar = cryptogram.toCharArray();

        for (char c : toChar) {

            String add = String.valueOf(hashSet.add(String.valueOf(c)));
            add = cryptogram;
        }
        answer = cryptogram;


        return answer;
    }
}


