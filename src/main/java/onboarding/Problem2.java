package onboarding;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "";
        Stack<String> stk = new Stack<String>();
        String[] arr = cryptogram.split("");

        stk.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            String str = arr[i];

            if(!stk.peek().equals(str)){
                stk.push(str);
            }else if(stk.peek().equals(str)){
                stk.pop();
            }

        }

        for(String s : stk){
            answer+=s;
        }

        return answer;
    }

}
