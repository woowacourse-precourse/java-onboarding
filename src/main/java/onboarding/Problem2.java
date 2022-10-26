package onboarding;

import static onboarding.Problem2.Decryptor.*;

import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        return decrypt(cryptogram);
    }

    public static class Decryptor {

        private Decryptor() {
        }

        public static String decrypt(String cryptogram) {
            Stack<Character> cryptogramStack = deleteDuplicateCharacter(cryptogram);

            StringBuilder decryptStringBuilder = new StringBuilder();

            for (Character character : cryptogramStack) {
                decryptStringBuilder.append(character);
            }
            return decryptStringBuilder.toString();
        }

        private static Stack<Character> deleteDuplicateCharacter(String cryptogram) {
            Stack<Character> cryptogramStack = new Stack<>();
            char[] cryptogramCharArray = cryptogram.toCharArray();

            cryptogramStack.push(cryptogramCharArray[0]);
            for (int i = 1; i < cryptogram.length(); i++) {
                if (duplicateCharacter(cryptogramStack, cryptogramCharArray[i])) {
                    cryptogramStack.pop();
                    continue;
                }
                cryptogramStack.push(cryptogramCharArray[i]);
            }
            return cryptogramStack;
        }

        private static boolean duplicateCharacter(Stack<Character> cryptogramStack,
            Character target) {
            return !cryptogramStack.isEmpty() && cryptogramStack.peek() == target;
        }
    }
}
