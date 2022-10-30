package onboarding;

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    private static Queue<Integer> queue = new LinkedList<>();

    private static void indexOfDuplicatedChar(String cryptogram) {
        for(int i=0; i<cryptogram.length()-1; i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1))
                queue.offer(i);
        }
    }

    public static String solution(String cryptogram) {
        while(true) {
            indexOfDuplicatedChar(cryptogram);
            if(queue.isEmpty())
                break;
            int temp = 0;
            while(!queue.isEmpty()) {
                int idx = queue.poll();
                cryptogram = cryptogram.substring(0,idx - temp*2) + cryptogram.substring(idx+2 - temp*2);
                temp++;
            }
        }
        return cryptogram;
    }
}
