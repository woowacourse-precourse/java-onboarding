package onboarding;

import java.util.Stack;

public class Problem2 {

    static Stack<String> stack = new Stack<>();

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    public static boolean isEmpty(Stack checkStack){
        boolean returnBoolean = false;

        if (checkStack.isEmpty()){
            returnBoolean = true;
        }

        return returnBoolean;
    }
}
