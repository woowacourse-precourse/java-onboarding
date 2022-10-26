package onboarding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        char[] chars = cryptogram.toCharArray();
        Deque<Character> chDeque = new LinkedList<>();

        for(char ch : chars){
            if(!chDeque.isEmpty()){
                checkContinuous(chDeque, ch);
                continue;
            }
            chDeque.addLast(ch);
        }
        return answer;
    }

    static void checkContinuous(Deque<Character> chDeque, char ch){
        if(chDeque.getLast() == ch){
            chDeque.removeLast();
        }
    }
}
