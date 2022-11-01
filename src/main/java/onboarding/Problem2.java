package onboarding;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Deque<Character> crypto = new ArrayDeque<>();
        crypto.addLast(cryptogram.charAt(0));
        for(int i=1; i<cryptogram.length(); i++){
            if(crypto.getLast()==cryptogram.charAt(i)){
                crypto.removeLast();
                continue;
            }
            else{
                crypto.addLast(cryptogram.charAt(i));
            }
        }
        Iterator iter = crypto.iterator();
        while(iter.hasNext()){
            answer += iter.next();
        }
        return answer;
    }
}
