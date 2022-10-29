package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_BEFORE_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_START_INDEX;
import static onboarding.problem2.consts.CryptogramStringConst.CRYPTOGRAM_SPLIT_VALUE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Decryptor {

    private Decryptor() {
    }

    public static String decrypt(String cryptogram) {
        List<String> cryptogramList = Arrays.stream(cryptogram.split(CRYPTOGRAM_SPLIT_VALUE))
            .collect(Collectors.toList());
        boolean removeDuplicateCharacter = true;

        while (removeDuplicateCharacter) {
            removeDuplicateCharacter = findAndDeleteDuplicateCharacter(cryptogramList);
        }
        return decryptCharacterToString(cryptogramList);
    }

    private static boolean findAndDeleteDuplicateCharacter(List<String> cryptogramList) {
        boolean removeDuplicateCharacter = false;
        int startCursor;
        String startCharacter;
        String nowCharacter;

        for (int i = CHARACTER_START_INDEX; i < cryptogramList.size(); i++) {
            startCursor = i - CHARACTER_BEFORE_INDEX;
            startCharacter = cryptogramList.get(startCursor);
            nowCharacter = cryptogramList.get(i);

            if (startCharacter.equals(nowCharacter)) {
                deleteDuplicateCharacter(cryptogramList, nowCharacter, startCursor);
                removeDuplicateCharacter = true;
                i = startCursor;
            }
        }
        return removeDuplicateCharacter;
    }

    private static void deleteDuplicateCharacter(List<String> cryptogramList, String nowCharacter,
        int startCursor) {
        while (validateDuplicateCharacter(cryptogramList, nowCharacter, startCursor)) {
            cryptogramList.remove(startCursor);
        }
    }

    private static boolean validateDuplicateCharacter(List<String> cryptogramList, String nowCharacter,
        int startCursor) {
        return !cryptogramList.isEmpty() && cryptogramList.get(startCursor).equals(nowCharacter);
    }

    private static String decryptCharacterToString(List<String> cryptogramList) {
        StringBuilder decryptStringBuilder = new StringBuilder();

        cryptogramList.forEach(decryptStringBuilder::append);
        return decryptStringBuilder.toString();
    }
}
