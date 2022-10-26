package onboarding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String preProcess = cryptogram;
        while (true) {
            String postProcess = process(preProcess);
            if (postProcess.equals(preProcess)) return postProcess;
            preProcess = postProcess;
        }
    }

    static String process(String str){
        String temp = "";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {
            //Stack이 비어있을 경우, 다음 turn
            if (stack.isEmpty()) {stack.push(x); continue;}

            //새로 들어온 값이 Stack의 peek값과 다를 경우 :
            //stack size가 1일때 -> stack에 있는 값은 중복되지 않은 문자 이므로, pop하여 Queue에 추가
            //stack size가 1보다 클 경우 -> stack에 있는 값은 중복된 문자 이므로, Stack clear
            if(stack.peek()!=x) {
                if(stack.size()==1) queue.offer(stack.pop());
                else stack.clear();
            }
            stack.push(x);
        }

        if (stack.size() == 1) queue.offer(stack.pop());
        while (!queue.isEmpty()) temp += queue.poll();

        return temp;
    }
}
