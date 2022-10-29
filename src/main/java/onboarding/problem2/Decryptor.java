package onboarding.problem2;

import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_BEFORE_INDEX;
import static onboarding.problem2.consts.CryptogramIndexConst.CHARACTER_START_INDEX;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Decryptor {

    private Decryptor() {
    }

    public static String decrypt(String cryptogram) {
        List<String> strings = Arrays.stream(cryptogram.split("")).collect(Collectors.toList());
        boolean removeDuplicateCharacter = false;

        while (!removeDuplicateCharacter) {
            removeDuplicateCharacter = true;
            for (int i = CHARACTER_START_INDEX; i < strings.size(); i++) {
                int startCursor = i - CHARACTER_BEFORE_INDEX;
                if (strings.get(startCursor).equals(strings.get(i))) {
                    removeDuplicateCharacter = false;
                    String target = strings.get(i);
                    while (strings.size() > 0 && strings.get(startCursor).equals(target)) {
                        strings.remove(startCursor);
                    }
                    i = startCursor;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        strings.stream().forEach(sb::append);
        return sb.toString();
    }
}
