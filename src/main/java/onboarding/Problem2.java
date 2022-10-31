package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] cry = cryptogram.toCharArray();
        Stack stack = new Stack();
        int count = 0;

        for (int i = 0 ; i < cryptogram.length() ; i ++){
            System.out.println(stack);

            if(stack.size() == 0){
                stack.push(cry[i]);
                continue;
            }

            if(String.valueOf(stack.peek()).charAt(0) == cry[i]) {
                count = 1;
                continue;
            }

            if(count == 0){
                stack.push(cry[i]);
            }else{
                stack.pop();
                if(stack.size() == 0){
                    stack.push(cry[i]);
                    count = 0;
                    continue;
                } else if(String.valueOf(stack.peek()).charAt(0) == cry[i]) {
                    continue;
                }
                stack.push(cry[i]);
                count = 0;
            }
        }
        if(count == 1){
            stack.pop();
        }

        System.out.println(stack);
        StringBuffer answer = new StringBuffer();

        while (stack.size() != 0){
            answer.append(stack.pop());
        }
        System.out.println(answer);
        String a = String.valueOf(answer.reverse());
        return a;
    }
}
