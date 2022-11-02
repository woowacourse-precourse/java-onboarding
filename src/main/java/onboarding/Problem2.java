package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        Stack<Character> decode = buildDecodedStack(cryptogram);

        return convertStackToStr(decode);
    }

    public static String convertStackToStr(Stack<Character> decode){
        String str = "";
        while(!decode.empty()){
            str = decode.pop() + str;
        } // 스택을 문자열로 변환

        return str;
    }

    public static Stack<Character> buildDecodedStack(String cryptogram){
        Stack<Character> decode = new Stack<Character>(); // 해독된 문자가 쌓일 스택
        char nowChar;
        int len = cryptogram.length();


        for(int i=0; i<len; i++){
            nowChar = cryptogram.charAt(i);
            if(decode.empty()){
                decode.push(nowChar);
            }
            else if(decode.peek() == nowChar){
                decode.pop();
            }
            else{
                decode.push(nowChar);
            }
        } // 스택(이전까지 해독된 문자열)의 마지막 글자와 새로운 글자를 대조 후 해독

        return decode;
    }

    
}
