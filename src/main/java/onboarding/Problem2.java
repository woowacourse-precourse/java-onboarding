package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decoder(cryptogram);
    }

    public static String decoder(String cryptogram){
        Stack<Character> decode = new Stack<>();
        String result="";
        for(int i=cryptogram.length()-1; i>=0; i--){
            if(!decode.empty()){
                if(decode.peek()==cryptogram.charAt(i)){
                    decode.pop();
                    continue;
                }
            }
            decode.push(cryptogram.charAt(i));
        }
        while(!decode.empty()){
            result=result+decode.peek();
            decode.pop();
        }

        return result;
    }
}