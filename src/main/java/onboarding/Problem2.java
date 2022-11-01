package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> decode = new Stack<Character>(); // 해독된 문자가 쌓일 스택
        int len = cryptogram.length();


        for(int i=0; i<len; i++){
            char nowChar = cryptogram.charAt(i);
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

        while(!decode.empty()){
            answer = decode.pop() + answer;
        } // 스택을 문자열로 변환

        return answer;
    }
    
}
