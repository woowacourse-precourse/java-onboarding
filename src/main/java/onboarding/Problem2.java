package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = deleteReduplicationString(cryptogram);
        return answer;
    }

    // 반복문을 통해 문자를 만드는 함수
    public static String deleteReduplicationString(String cryptogram) {
        String resultString = "";

        // 스택을 활용해 중복 문자 제거
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < cryptogram.length(); i++) {
            String nextChar = cryptogram.substring(i, i+1);
            stack.push(nextChar);
            while (stack.size() >= 2 && checkReduplication(stack.get(stack.size()-2), stack.get(stack.size()-1))) {
                stack.pop();
                stack.pop();
            };
        }
        for (String s : stack) resultString += s;

        return resultString;
    }

    // 중복 여부를 체크하는 함수
    public static boolean checkReduplication(String s1, String s2) {
        return s1.equals(s2);
    }
}
