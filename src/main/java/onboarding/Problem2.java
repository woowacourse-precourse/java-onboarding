package onboarding;

import java.util.Stack;
//1. 연속 중복 문자가 있는지 확인
//2. 있으면 해당 중복 문자 삭제
//2-1. 없으면 해당 문자열 반환
//3. 삭제 후 문자열로 1번으로 다시 돌아감
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        while (checkDuplicate(answer)) {
            answer = removeDuplicate(answer);
        }
        // Stack<Character> stack = new Stack<>();
        //
        // for (int i = 0; i < cryptogram.length(); i++) {
        //     if(!stack.isEmpty() && stack.peek().equals(cryptogram.charAt(i))) {
        //         stack.pop();
        //         while(cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
        //             i++;
        //         }
        //
        //     } else {
        //         stack.push(cryptogram.charAt(i));
        //     }
        // }
        //
        // for (Character character : stack) {
        //     answer.append(character);
        // }
        return answer;
    }

    public static boolean checkDuplicate(String str) {
        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    public static String removeDuplicate(String str) {
        char pop = ' ';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(pop == str.charAt(i) || (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1))) {
                pop = str.charAt(i);
            } else {
                pop = ' ';
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }
}
