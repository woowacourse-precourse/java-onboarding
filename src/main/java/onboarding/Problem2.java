package onboarding;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {

        //커밋1. 스택 이용하여 중복 제거하기
        Stack<Character> stack = new Stack<>();
        for(int i =0 ; i<cryptogram.length();i++){
            Character c = cryptogram.charAt(i);

            if(stack.isEmpty() || stack.peek() != c) stack.add(c);
            else stack.pop();
        }

    }


}