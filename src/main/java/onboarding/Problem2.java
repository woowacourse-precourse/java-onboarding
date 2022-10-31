package onboarding;

/*
기능 구현 사항
1. 이전 문자열과 바꾼 문자열이 동일하면 루프 멈추기
2. 현재 문자가 다음 문자와 같으면
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String currentCryptogram = removeOverlapWord(cryptogram);
        return currentCryptogram;
    }

    private static class Stack {
        private int top;
        private final int stackSize;
        private final char[] stackArr;

        public Stack(int stackSize) {
            this.stackSize = stackSize;
            this.top = -1;
            this.stackArr = new char[this.stackSize];
        }

        public boolean isEmpty() {
            return (top == -1);
        }

        public boolean isFull() {
            return (top == this.stackSize - 1);
        }

        public void push(char letter) {
            if(!isFull()) {
                stackArr[++top] = letter;
            }
        }

        public char pop() {
            if(!isEmpty()) {
                return stackArr[top--];
            }
            return 0;
        }

        public char peek() {
            if(!isEmpty()) {
                return stackArr[top];
            }
            return 0;
        }
        public String changeArrayToString() {
            if(isEmpty()) {
                return "";
            }
            String stackString = new String(stackArr);
            String slicedStackString = stackString.substring(0, top+1);
            return slicedStackString;
        }
    }

    private static String removeOverlapWord(String cryptogram) {
        Stack stack = new Stack(cryptogram.length());
        for(int i = 0; i<cryptogram.length(); i++) {
            char cryptoLetter = cryptogram.charAt(i);
            if(!stack.isEmpty() && stack.peek() == cryptoLetter) {
                stack.pop();
                continue;
            }
            stack.push(cryptoLetter);
        }
        return stack.changeArrayToString();
    }
}
