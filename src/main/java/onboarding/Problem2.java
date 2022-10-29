package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<Character> temp = new Stack<>();
        char[] str = cryptogram.toCharArray();
        StringBuffer sb = new StringBuffer();
        String answer = "";

        for (int i=0; i < cryptogram.length(); i++){
            if (temp.size() == 0){
                temp.push(str[i]);
            } else{
                if (temp.peek() != str[i]){
                    temp.push(str[i]);
                } else {
                    temp.pop();
                }
            }
        }

        for (char i : temp){
            sb.append(i);
        }
        answer = sb.toString();

        return answer;
    }
}
