package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        return checkDuplicateWord(cryptogram);
    }

    private static String checkDuplicateWord(String cryptogram) {
        Stack<Integer> indexStack = new Stack<>();
        while (true) {
            for (int i = 0; i < cryptogram.length() - 1; i++) {
                if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                    indexStack.push(i);
                    indexStack.push(i + 1);
                    i++;
                }
            }
            if (indexStack.size() == 0) {
                break;
            }
            cryptogram = removeDuplicateWord(cryptogram, indexStack);
        }
        return cryptogram;
    }
    private static String removeDuplicateWord(String cryptogram, Stack<Integer> indexStack) {
        int index;
        StringBuffer stringBuffer = new StringBuffer(cryptogram);
        while (!indexStack.empty()) {
            index = indexStack.pop();
            stringBuffer.deleteCharAt(index);
        }
        return stringBuffer.toString();
    }
}
