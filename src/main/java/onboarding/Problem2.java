package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deleteDuplicatedString(cryptogram);
        return answer;
    }

    public static String deleteDuplicatedString(String cryptogram){
        String plainText;
        Stack<Character> stack = new Stack<>();
        char[] cryptogramChar = cryptogram.toCharArray();

        char preDeletedChar = Character.MAX_VALUE;
        for(int i=0; i<cryptogramChar.length; i++){
            if(preDeletedChar == cryptogramChar[i])
                continue;
            if(!stack.empty() && (stack.peek() == cryptogramChar[i]))
                preDeletedChar = stack.pop();
            else {
                stack.push(cryptogramChar[i]);
                preDeletedChar = Character.MAX_VALUE;
            }
        }
        plainText = changeStackCharToString(stack);
        return plainText;
    }

    public static String changeStackCharToString(Stack<Character> stack){
        StringBuilder sb = new StringBuilder();
        stack.forEach(sb::append);
        return sb.toString();
    }

}
