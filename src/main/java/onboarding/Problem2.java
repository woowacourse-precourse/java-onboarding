package onboarding;

import java.util.Stack;

public class Problem2 {
    public static String solution(String cryptogram) {
        String decryption = "";

        while (true) {
            decryption = deleteDuplicate(cryptogram, cryptogram.length());

            if (cryptogram.equals(decryption)) break;

            cryptogram = decryption;
        }

        return decryption;
    }

    private static String deleteDuplicate(String cryptogram, int size) {
        Stack<Character> decryptionCharacters = new Stack<>();
        String decryption = "";

        for (int i = 0; i < size; i++) {
            if (decryptionCharacters.isEmpty()) {
                decryptionCharacters.push(cryptogram.charAt(i));
                continue;
            }

            if (decryptionCharacters.peek() == cryptogram.charAt(i)) {
                // 마지막 중복값의 위치 구하기
                i = findLastDuplicatedIndex(cryptogram, i);
                decryptionCharacters.pop();
                continue;
            }

            decryptionCharacters.push(cryptogram.charAt(i));
        }

        while (!decryptionCharacters.isEmpty()) {
            decryption = decryptionCharacters.pop() + decryption;
        }

        return decryption;
    }

    private static int findLastDuplicatedIndex(String cryptogram, int index) {
        char duplicatedCharacter = cryptogram.charAt(index);

        while (index < cryptogram.length()) {
            if (duplicatedCharacter != cryptogram.charAt(index)) {
                break;
            }

            index++;
        }

        return index - 1;
    }
}
