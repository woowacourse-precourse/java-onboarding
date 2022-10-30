package onboarding;

import onboarding.problem2.Decoder;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        return decodeCryptogram(cryptogram);
    }

    private static String decodeCryptogram(String cryptogram) {
        LinkedList<Character> characterLinkedList = convertStringToCharacterLinkedList(cryptogram);
        findAndRemoveDuplicate(characterLinkedList);
        return convertCharacterLinkedListToString(characterLinkedList);
    }
}
