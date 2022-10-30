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

        /**
         * cryptogram의 값을 하나하나 다 비교하는 과정
         * 비교했을 때 , 그 갯수가 짝수가 아닐 때만 값을 저장한다. (중복을 제거함)
         */
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

        /**
         * 중복을 제거한 값들을 answer에 차례대로 담는다.
         */
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            answer += it.next();
        }


        return answer;
    }
}
