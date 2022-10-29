package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CRYPTOGRAM_DUPLICATE_START_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CRYPTOGRAM_START_INDEX;

import java.util.Stack;

public class Decryptor {

    private Decryptor() {
    }

    public static String decrypt(String cryptogram) {
        Stack<Character> cryptogramStack = deleteDuplicateCharacter(cryptogram);

        return decryptCharacterToString(cryptogramStack);
    }

    private static String decryptCharacterToString(Stack<Character> cryptogramStack) {
        StringBuilder decryptStringBuilder = new StringBuilder();

        cryptogramStack.forEach(decryptStringBuilder::append);
        return decryptStringBuilder.toString();
    }

    private static Stack<Character> deleteDuplicateCharacter(String cryptogram) {
        Stack<Character> cryptogramStack = new Stack<>();
        char[] cryptogramCharArray = cryptogram.toCharArray();

        cryptogramStack.push(cryptogramCharArray[CRYPTOGRAM_START_INDEX]);
        for (int i = CRYPTOGRAM_DUPLICATE_START_INDEX; i < cryptogram.length(); i++) {
            boolean skipCursorFlag = addValidCryptogramCharacter(cryptogramStack,
                cryptogramCharArray[i]);
            if (skipCursorFlag) {
                i += skipCryptogramCursor(cryptogramCharArray, cryptogramCharArray[i], i);
            }
        }
        return cryptogramStack;
    }

    private static boolean addValidCryptogramCharacter(Stack<Character> cryptogramStack,
        char target) {
        if (duplicateCharacter(cryptogramStack, target)) {
            cryptogramStack.pop();
            return true;
        }
        cryptogramStack.push(target);
        return false;
    }

    private static int skipCryptogramCursor(char[] cryptogramCharArray, char target,
        int nowCursor) {
        int skipCursor = 0;
        while (++nowCursor != cryptogramCharArray.length
            && cryptogramCharArray[nowCursor] == target) {
            skipCursor++;
        }
        return skipCursor;
    }

    private static boolean duplicateCharacter(Stack<Character> cryptogramStack, char target) {
        return !cryptogramStack.isEmpty() && cryptogramStack.peek() == target;
    }
}
