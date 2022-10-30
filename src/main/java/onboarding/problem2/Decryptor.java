package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_BEFORE_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_START_INDEX;
import static onboarding.problem2.consts.CryptogramStringConst.CRYPTOGRAM_SPLIT_VALUE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Decryptor {

    private static boolean isRemoveDuplicateCharacter = false;
    private static List<String> cryptogramList;

    private Decryptor() {
    }

    public static String decrypt(String cryptogram) {
        cryptogramList = Arrays.stream(cryptogram.split(CRYPTOGRAM_SPLIT_VALUE))
            .collect(Collectors.toList());
        isRemoveDuplicateCharacter = true;

        while (isRemoveDuplicateCharacter) {
            processDuplicateCharacter();
        }
        return decryptCharacterToString();
    }

    private static void processDuplicateCharacter() {
        int startCursor;
        int nowCursor = CHARACTER_START_INDEX;

        isRemoveDuplicateCharacter = false;
        while (nowCursor < cryptogramList.size()) {
            startCursor = nowCursor - CHARACTER_BEFORE_INDEX;
            nowCursor = findDuplicateCharacter(nowCursor, startCursor);
        }
    }

    private static int findDuplicateCharacter(int nowCursor, int startCursor) {
        String startCharacter = cryptogramList.get(startCursor);
        String nowCharacter = cryptogramList.get(nowCursor);

        if (startCharacter.equals(nowCharacter)) {
            deleteDuplicateCharacter(nowCharacter, startCursor);
            isRemoveDuplicateCharacter = true;
            return ++startCursor;
        }
        return ++nowCursor;
    }

    private static void deleteDuplicateCharacter(String nowCharacter, int startCursor) {
        while (isDuplicateCharacter(nowCharacter, startCursor)) {
            cryptogramList.remove(startCursor);
        }
    }

    private static boolean isDuplicateCharacter(String nowCharacter, int startCursor) {
        return cryptogramList.size() > startCursor && cryptogramList.get(startCursor)
            .equals(nowCharacter);
    }

    private static String decryptCharacterToString() {
        StringBuilder decryptStringBuilder = new StringBuilder();

        cryptogramList.forEach(decryptStringBuilder::append);
        return decryptStringBuilder.toString();
    }
}
