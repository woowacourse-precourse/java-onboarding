package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        int now = 0;
        while(now<cryptogram.length()){
            if(stack.size() !=0){
                if(stack.size() !=0) {
                    if (!stack.get(stack.size()-1).equals(cryptogram.charAt(now))) {
                        if(check){
                            stack.pop();
                        }else{
                            stack.add(cryptogram.charAt(now));
                            now ++;
                        }
                        check =false;
                    }else{
                        check =true;
                        now ++;
                    }
                }
            }else{
                stack.add(cryptogram.charAt(now));
                now++;
            }
            check = check;
        }
        if(check){
            stack.pop();
        }
        for(char c: stack){
            answer += c;
        }
        return answer;
    }
}
