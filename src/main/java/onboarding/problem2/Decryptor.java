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
            addValidCryptogramCharacter(cryptogramStack, cryptogramCharArray[i]);
        }
        return cryptogramStack;
    }

    private static void addValidCryptogramCharacter(Stack<Character> cryptogramStack, char target) {
        if (duplicateCharacter(cryptogramStack, target)) {
            cryptogramStack.pop();
            return;
        }
        cryptogramStack.push(target);
    }

    private static boolean duplicateCharacter(Stack<Character> cryptogramStack, char target) {
        return !cryptogramStack.isEmpty() && cryptogramStack.peek() == target;
    }
}
