package onboarding;

import java.util.Stack;

public class Problem2 {
    public Problem2(){
    }

    public static String solution(String cryptogram) {
        if(strLenException(cryptogram) || !isStringLowerCase(cryptogram)){
            return cryptogram;
        }
        Stack<Character> stack = new Stack();
        char[] ch = cryptogram.toCharArray();
        stack.push(ch[0]);
        for(int i = 1; i < cryptogram.length(); i++){
            if(stack.isEmpty()){
                stack.push(ch[i]);
            }
            else if(stack.lastElement() == ch[i]){
                stack.pop();
            }
            else if(stack.lastElement() != ch[i]){
                stack.push(ch[i]);
            }
        }
        String answer = printStack(stack);
        return answer;
    }

    public static boolean strLenException(String string){
        return string.length() < 1 || string.length() > 1000;
    }

    public static boolean isStringLowerCase(String string){
        char[] charArray = string.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(!Character.isLowerCase(charArray[i]))
                return false;
        }
        return true;
    }
    private static String printStack(Stack stack){
        String str = "";
        if(stack.isEmpty()){
            return str;
        }
        while(!stack.isEmpty()){
            str = stack.pop() + str;
        }
        return str;
    }
}
