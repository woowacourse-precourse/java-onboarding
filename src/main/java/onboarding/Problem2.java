package onboarding;

import java.util.Stack;

public class Problem2 {

    static Stack<Character> stack=new Stack<>();

    public static String solution(String cryptogram) {
        StringBuilder sb=new StringBuilder();
        if (validation("cryptogram_length",cryptogram.length())
                &&
                validation("cryptogram_regex",cryptogram)){

            distinctElement(cryptogram);

            while (!stack.isEmpty()){
                sb.append(stack.pop());
            }
        }
        return sb.reverse().toString();
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

    private static <T> boolean validation(String err_type,T err_param){

        if (err_type.equals("cryptogram_length")&&err_param instanceof Integer){
            int crypto_length = (int) err_param;
            return 0<crypto_length&&crypto_length<1001;
        }

        else if (err_type.equals("cryptogram_regex")&&err_param instanceof String){
            String cryptogram = (String) err_param;
            if (cryptogram.matches("^[a-z]*$")) return true;
            else return false;
        }

        return false;
    }
}
