package onboarding.problem2;

import java.util.Stack;

public class DuplicationEliminator {

    /**
    * 주어진 Stack을 문자열로 치환합니다.
    * ex) [A,B,C,D] => "ABCD"
    */
    private static String getStringFromStack(Stack<Character> stack) {
        String text = "";
        while(!stack.isEmpty()) {
            text += stack.peek();
            stack.pop();
        }
        StringBuffer answerBuffer = new StringBuffer(text).reverse();
        return answerBuffer.toString();
    }

    /**
     * dupliCount 만큼 stack을 제거합니다.
     */
    private static void removeDuplicateCharacter(Stack<Character> stack, Integer dupliCount) {
        for (int i=0; i<dupliCount; i++) {
            stack.pop();
        }
    }

    /**
     * 주어진 문자열에 중복된 문자가 있는지 검증합니다.
     */
    public static boolean isDuplicate(String cryptogram) {
        for (int i=0; i<cryptogram.length()-1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * cryptogram에 있는 모든 중복된 문자를 제거한 후 그 값을 반환합니다.
     */
    public static String remove(String cryptogram, Stack<Character> stack) {
        int dupliCount = 1;
        boolean isDuplicate = false;
        for (int i = 0; i < cryptogram.length(); i++) {
            if (!stack.isEmpty() && cryptogram.charAt(i) == stack.peek()) {
                isDuplicate = true;
                dupliCount += 1;
                if (i == cryptogram.length() - 1 && (isDuplicate || cryptogram.length() == 2)) {
                    stack.push(cryptogram.charAt(i));
                    removeDuplicateCharacter(stack, dupliCount);
                    break;
                }
            } else if (!stack.isEmpty() && cryptogram.charAt(i) != stack.peek() && isDuplicate) {
                removeDuplicateCharacter(stack, dupliCount);
                dupliCount = 1;
                isDuplicate = false;
            }
            stack.push(cryptogram.charAt(i));
        }
        return DuplicationEliminator.getStringFromStack(stack);
    }


}
