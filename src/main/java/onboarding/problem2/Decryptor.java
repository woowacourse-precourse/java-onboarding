package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_BEFORE_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_START_INDEX;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Decryptor {

    private Decryptor() {
    }

    public static String decrypt(String cryptogram) {
        List<String> cryptogramList = Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
        boolean removeDuplicateCharacter = true;

        while (removeDuplicateCharacter) {
            removeDuplicateCharacter = deleteDuplicateCharacter(cryptogramList);
        }
        return decryptCharacterToString(cryptogramList);
    }

    private static boolean deleteDuplicateCharacter(List<String> cryptogramList) {
        boolean removeDuplicateCharacter = false;
        for (int i = CHARACTER_START_INDEX; i < cryptogramList.size(); i++) {
            int startCursor = i - CHARACTER_BEFORE_INDEX;
            if (cryptogramList.get(startCursor).equals(cryptogramList.get(i))) {
                removeDuplicateCharacter = true;
                String target = cryptogramList.get(i);
                while (cryptogramList.size() > 0 && cryptogramList.get(startCursor).equals(target)) {
                    cryptogramList.remove(startCursor);
                }
                i = startCursor;
            }
        }
        return removeDuplicateCharacter;
    }

    private static String decryptCharacterToString(List<String> cryptogramList) {
        StringBuilder decryptStringBuilder = new StringBuilder();

        cryptogramList.forEach(decryptStringBuilder::append);
        return decryptStringBuilder.toString();
    }
}
