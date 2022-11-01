package onboarding;

import java.util.Stack;

/*
기능목록
1. 중복되는 문자 제거 (1회전만)
2. 중복이 없어질때까지 중복 문자 제거
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack=new Stack<>();
        boolean flag=false; //중복 제거가 된 경우 true
        while(true) {
            flag=false;
            char duplication=cryptogram.charAt(0); //중복된 문자
            stack.push(cryptogram.charAt(0));
            for (int i = 1; i < cryptogram.length(); i++) {
                char c = cryptogram.charAt(i);
                if (duplication != c) {
                    stack.push(c);
                    duplication = c;
                } else {
                    if (!stack.isEmpty() && stack.peek()==duplication) {
                        stack.pop();
                    }
                    flag=true;
                }
            }
            cryptogram = "";
            for (char c : stack) {
                cryptogram += c;
            }
            //System.out.println(cryptogram);
            if(flag==false || cryptogram.length()==0){
                break;
            }
            stack.clear();

        }

        return cryptogram;
    }
}
