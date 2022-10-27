package onboarding;

import java.util.Stack;

public class Problem2 {

    /**
     * 문자열을 스택에 복사한다.
     *
     * @param stack 복사 받을 스택
     * @param str 복사할 문자열
     */
    private static void copyStringToStack(Stack<Character> stack, String str) {
        for (int index = 0; index < str.length(); index++) {
            stack.push(str.charAt(index));
        }
    }

    /**
     * 스택의 최상단 문자가 해당 문자와 같다면 삭제, 다를 때까지 반복
     *
     * @param stack 삭제할 스택
     * @param ch 비교할 문자
     */
    private static boolean deleteIfSameCharacter(Stack<Character> stack, Character ch){
        boolean deleted = false;
        while (!stack.isEmpty() && (stack.peek() == ch)){
            stack.pop();
            deleted = true;
        }
        return deleted;
    }

    /**
     * 스택의 연속적인 중복 문자들 삭제한다. 중복 문자가 아니라면 다른 스택에 삽입
     * 삭제할 스택이 비어 있다면, 스왑하여 수행한다.
     *
     * @param destStack 삽입 받을 스택
     * @param srcStack 삭제할 스택
     * @return 삭제한 값이 있다면 true, 아니라면 false
     */
    private static boolean deleteConsecutiveDuplicateCharacters(
            Stack<Character> destStack, Stack<Character> srcStack
    ) {
        if (srcStack.isEmpty()){
            Stack<Character> tmpStack = srcStack;
            srcStack = destStack;
            destStack = tmpStack;
        }

        boolean deleted = false;
        while (!srcStack.isEmpty()) {
            Character popOfSrcStack = srcStack.pop();
            if (deleteIfSameCharacter(srcStack, popOfSrcStack)){
                deleted = true;
            } else{
                destStack.push(popOfSrcStack);
            }
        }
        return deleted;
    }

    /**
     * 스택에서 다른 스택으로 옮긴다.
     *
     * @param fromStack 삭제할 스택
     * @param toStack 삽입 받을 스택
     */
    private static void fromStackToStack(Stack<Character> fromStack, Stack<Character> toStack){
        while (!fromStack.isEmpty()){
            toStack.push(fromStack.pop());
        }
    }

    public static String solution(String cryptogram) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        copyStringToStack(leftStack, cryptogram);
        while (true) {
            boolean deleted = deleteConsecutiveDuplicateCharacters(rightStack, leftStack);
            if (!deleted)
                break;
        }
        // rightStack을 복사받을 것이다. leftStack을 복사 받을 경우 문자열이 뒤집어진다.
        fromStackToStack(leftStack, rightStack);

        int resultSize = rightStack.size();
        char[] result = new char[resultSize];
        for (int index = 0; index < resultSize; index++){
            result[index] = rightStack.pop();
        }
        return (new String(result));
    }
}
