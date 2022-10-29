package onboarding.problem2;

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
            for (int i = 1; i < strings.size(); i++) {
                int startCursor = i - 1;
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
