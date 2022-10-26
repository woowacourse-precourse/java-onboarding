package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        Stack<Character> back = new Stack<>();
        char[] arr;
        // 중복제거
        // Q1. 스택으로 중복제거시 다시 스택으로 문자열을 되돌려야 하는데 양방향 큐를 쓰는게 낫지 않는가?
        // Q2. replaceAll 사용가능성?
        for(int i=0; i<cryptogram.length(); i++){
            if(!stack.empty() && stack.peek() == cryptogram.charAt(i))
                stack.pop();
            else
                stack.push(cryptogram.charAt(i));
        }

        // 원래 문자열로 되돌리기
        while(!stack.empty()) {
            back.push(stack.pop());
        }

        // char to string
        arr = new char[back.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = back.pop();
        }
        answer = new String(arr);

        return answer;
    }
}
