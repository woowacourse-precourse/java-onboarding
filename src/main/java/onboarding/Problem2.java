package onboarding;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] chars = cryptogram.toCharArray();
        Deque<Character> chDeque = new LinkedList<>();

        for(char ch : chars){
            if(!chDeque.isEmpty()){
                checkContinuous(chDeque, ch);
                continue;
            }
            chDeque.addLast(ch);
        }
        return charToString(chDeque);
    }

    static void checkContinuous(Deque<Character> chDeque, char ch){
        if(chDeque.getLast() == ch){
            chDeque.removeLast();
        }
    }

    static String charToString(Deque<Character> chDeque){
        String result = "";
        while (!chDeque.isEmpty()) {
            result += Character.toString(chDeque.removeFirst());
        }
        return result;
    }
}
