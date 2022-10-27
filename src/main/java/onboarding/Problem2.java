package onboarding;

import java.util.*;

public class Problem2 {
    private static Stack<String> stack = new Stack<String>();
    public static String solution(String cryptogram) {
        List<String> buffer = Arrays.asList(cryptogram.split("")); // ['b','r','w','p','p','w']
        pushStack(buffer);
        String answer = parseStack(stack);
        return answer;
    }


    public static List<String> pushStack(List<String> buffer){
        for(int i = 0; i < buffer.size(); i++){
            push(buffer, i);
        }
        return buffer;
    }

}
