package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String deciphered = decipher(cryptogram);

        while(true){
             String curDeciphered = decipher(deciphered);

             if(deciphered.equals( curDeciphered )){
                 answer = deciphered;
                 break;
             }else{
                 deciphered = curDeciphered;
             }
        }

        return answer;
    }

    private static String decipher(String cryptogram){
        final StringBuilder sb = new StringBuilder();
        char[] cryptoChars = cryptogram.toCharArray();
        Stack<Character> stk = new Stack<>();
        int i = 1;

        for( ; i<cryptogram.length(); i++){
            if(cryptoChars[i] == cryptoChars[i-1]){
                stk.push(cryptoChars[i]);
                cryptoChars[i-1] = '0';
                while(i<cryptogram.length() && cryptoChars[i] == stk.peek()){
                    cryptoChars[i] = '0';
                    ++i;
                }
            }
        }

        for(char c :cryptoChars){
            if(c != '0'){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
