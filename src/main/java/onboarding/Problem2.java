package onboarding;


import java.util.Arrays;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        // Stack st를 선언해준다.
        Stack<Character> st = new Stack<>();
        // cryptogram을 char형 배열에 담아준다.
        char[] arr =cryptogram.toCharArray();

        // for 문을 통해 arr을 char c에 담아주고, 조건문을 사용해 스택 st가 공백이거나 ,
        // st의 가장 최근의 값이 char c 와 같지 않으면 push를 해준다. 그 경우가 아니라면 st.pop()

        for(char c : arr){
            if(st.empty() || st.peek() !=c){
                st.push(c);
            }
            else{
                st.pop();

            }
        }
        // vlalueof를 사용하여 Character형을 String으로 변환하여 replaceAll을 사용하여 알파벳 소문자가 아니라면
        // 공백값을 제거해준다.
        return String.valueOf(st).replaceAll("[^a-z]","");

    }


}