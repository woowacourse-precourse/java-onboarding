package onboarding;

import static onboarding.Problem2.CryptogramIndexConst.CRYPTOGRAM_DUPLICATE_START_INDEX;
import static onboarding.Problem2.CryptogramIndexConst.CRYPTOGRAM_START_INDEX;
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

            return decryptCharacterToString(cryptogramStack);
        }

        private static String decryptCharacterToString(Stack<Character> cryptogramStack) {
            StringBuilder decryptStringBuilder = new StringBuilder();

            for (Character character : cryptogramStack) {
                decryptStringBuilder.append(character);
            }
            return decryptStringBuilder.toString();
        }

        private static Stack<Character> deleteDuplicateCharacter(String cryptogram) {
            Stack<Character> cryptogramStack = new Stack<>();
            char[] cryptogramCharArray = cryptogram.toCharArray();

            cryptogramStack.push(cryptogramCharArray[CRYPTOGRAM_START_INDEX]);
            for (int i = CRYPTOGRAM_DUPLICATE_START_INDEX; i < cryptogram.length(); i++) {
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

    public abstract class CryptogramIndexConst {

        public static final int CRYPTOGRAM_START_INDEX = 0;
        public static final int CRYPTOGRAM_DUPLICATE_START_INDEX = 1;
    }
}
