package onboarding;

import java.util.Stack;

public class Problem2 {

    static Stack<Character> stack=new Stack<>();

    public static String solution(String cryptogram) {
        StringBuilder sb=new StringBuilder();

        try{
            checkCryptogramLength(cryptogram);
            checkCryptogramRegex(cryptogram);
            distinctElement(cryptogram);
            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }

            return sb.reverse().toString();
        }catch (Exception e){
            return e.getMessage();
        }
    }

    public static void distinctElement(String cryptogram){
        for (char x:cryptogram.toCharArray()){
            if (stack.isEmpty()) stack.push(x);
            else {
                char peek = stack.peek();
                if (x==peek) {
                    stack.pop();
                    continue;
                }
                stack.push(x);
            }
        }
    }
    public static void checkCryptogramLength(String cryptogram) throws Exception {
        int length = cryptogram.length();
        if (length<1||length>1000) throw new Exception("문자열의 길이가 범위를 벗어났습니다.");
    }

    public static void checkCryptogramRegex(String cryptogram) throws Exception{
        boolean matches = cryptogram.matches("^[a-z]*$");
        if(!matches) throw new Exception("암호문이 소문자로만 구성되지 않았습니다");
    }
}
