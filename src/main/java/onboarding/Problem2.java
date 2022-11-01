package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String dupCheck(String[] arr){
        String result = "";
        Stack<String> stk = new Stack<String>();
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
            result+=s;
        }
        return result;
    }
    public static String solution(String cryptogram) {
        String answer = "";
        String[] arr = cryptogram.split("");
        answer = dupCheck(arr);
        return answer;
    }

}
