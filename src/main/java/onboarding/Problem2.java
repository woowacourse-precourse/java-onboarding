package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        // 중복된 문자가 없을때까지 반복 호출
        while (checkString(cryptogram)) {
            cryptogram = removeOverlap(cryptogram);
        }
        answer = cryptogram;
        return answer;
    }

    // 문자열에서 중복된 문자가 있는지 확인하는 메서드
    static boolean checkString(String cryptogram) {
        boolean flag = false;
        String[] stringArr = cryptogram.split("");
        for (int i = 0; i < stringArr.length - 1; i++) {
            String first = stringArr[i];
            String second = stringArr[i + 1];
            if (first.equals(second)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    // 중복되는 문자를 제거하는 메서드
    static String removeOverlap(String cryptogram) {
        String[] stringArr = cryptogram.split("");
        Stack<String> stack = new Stack<>();
        String s = "";
        for (int i = 0; i < stringArr.length; i++) {
            if(!stack.isEmpty() && stack.peek().equals(stringArr[i])) {
                s = stack.pop();
            }
            if(!stringArr[i].equals(s)) {
                stack.push(stringArr[i]);
                s = "";
            }
        }

        StringBuilder sb = new StringBuilder();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
