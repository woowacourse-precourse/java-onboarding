package onboarding;

import onboarding.problem2.Problem2Validation;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    private static final int INPUT_MAX_LENGTH = 1000;
    private static final int INPUT_MIN_LENGTH = 1;


    public static String solution(String cryptogram) {
        String result = "";
        if (Problem2Validation.problem2InputValidation(cryptogram, INPUT_MIN_LENGTH, INPUT_MAX_LENGTH)) {
            result = compressOverlappingWord(cryptogram);
        }
        return result;
    }

    private static String compressOverlappingWord(String cryptogram) {
        StringBuilder afterCompressionExtractFromStack = new StringBuilder();
        Deque<Character> queue = compressStringWithDeque(cryptogram);
        usingQueueMakingCompressionResult(afterCompressionExtractFromStack, queue);
        return afterCompressionExtractFromStack.toString();
    }

    private static Deque<Character> compressStringWithDeque(String cryptogram) {
        Deque<Character> stack = new LinkedList<>();
        int idx = 0;
        while (idx < cryptogram.length()) {
            char thisTurnWordChar = cryptogram.charAt(idx);
            if (stack.isEmpty()) {
                addElementInStack(stack, thisTurnWordChar);
                idx += 1;
                continue;
            }
            Character stackPeekWordChar = stack.removeLast();
            if (stackPeekWordChar == thisTurnWordChar) {
                idx = findOverlappingWordCharIdx(stackPeekWordChar, cryptogram, idx + 1);
            } else if (stackPeekWordChar != thisTurnWordChar) {
                addElementInStack(stack, stackPeekWordChar);
                addElementInStack(stack, thisTurnWordChar);
                idx += 1;
            }

        }
        return stack;
    }


    private static void addElementInStack(Deque<Character> stack, char thisTurnWordChar) {
        stack.addLast(thisTurnWordChar);
    }

    private static int findOverlappingWordCharIdx(Character stackPeekWordChar,String cryptogram, int idx) {
        while (idx < cryptogram.length()) {
            if (cryptogram.charAt(idx) == stackPeekWordChar) {
                idx += 1;
                continue;
            }
            break;
        }
        return idx;
    }

    private static void usingQueueMakingCompressionResult(StringBuilder afterCompressionExtractFromStack, Deque<Character> queue) {
        while (!queue.isEmpty()) {
            afterCompressionExtractFromStack.append(queue.remove());
        }
    }

}
