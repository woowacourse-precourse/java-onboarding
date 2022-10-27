package onboarding;

import java.util.ArrayList;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {

        char[] character = cryptogram.toCharArray();
        Stack<Character> temp = new Stack<>();
        for(char x : character){
            if(temp.isEmpty()) temp.push(x);
            else{
                if (temp.peek() == x){
                    temp.pop();
                }
                else temp.push(x);
            }
        }
        String answer = "";
        for(char x : temp){
            answer += x;
        }
        return answer;
    }
}
