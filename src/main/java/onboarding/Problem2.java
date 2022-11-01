package onboarding;

import java.util.Stack;

public class Problem2 {

    public static class Message {
        private String value;
        public Message(String value) {
            validMessage(value);
            this.value = value;
        }

        private void validMessage(String value) {
            if (!(value.length() >= 1) || !(value.length() <= 1000)) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }

        public String deleteDuplication() {
            String answer = this.value;
            while (checkDuplication(answer)) {
                Stack<String> stack = new Stack<>();
                for (int i = 0; i < value.length(); i++) {
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(value.charAt(i)));
                        continue;
                    }
                    if (stack.peek().equals(String.valueOf(value.charAt(i)))) {
                        stack.pop();
                        continue;
                    } else {
                        stack.push(String.valueOf(value.charAt(i)));
                    }
                }
                answer = "";
                for (String s : stack) {
                    answer = answer + s;
                }
                System.out.println(answer);
            }
            return answer;
        }
        public boolean checkDuplication(String answer) {
            Stack<String> stack = new Stack<>();
            if (answer.length() == 1) {
                return false;
            }
            for (int i = 0; i < answer.length(); i++) {
                if (stack.isEmpty()) {
                    stack.push(String.valueOf(answer.charAt(i)));
                    continue;
                }
                if (stack.peek().equals(String.valueOf(answer.charAt(i)))) {
                    return true;
                } else {
                    stack.push(String.valueOf(answer.charAt(i)));
                }
            }
            return false;
        }
    }
    public static String solution(String cryptogram) {
        return new Message(cryptogram).deleteDuplication();
    }
}
