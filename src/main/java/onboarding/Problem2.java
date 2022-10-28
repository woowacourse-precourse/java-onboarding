package onboarding;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        LinkedHashSet<String> set = new LinkedHashSet<>();
        String test = cryptogram;
        int count = 0;

        for (int i = 0; i < cryptogram.length(); i++) {
            for (int j = 0; j < cryptogram.length(); j++) {
                if (cryptogram.charAt(j) == cryptogram.charAt(i)) {
                    count++;
                }
            }
            if (count % 2 != 0) {
                set.add(""+cryptogram.charAt(i));
            }


            count = 0;
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            answer += it.next();
        }


        return answer;
    }
}
