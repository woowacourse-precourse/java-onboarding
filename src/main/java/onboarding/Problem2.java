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

    private static String convertCharacterLinkedListToString(LinkedList<Character> characterLinkedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : characterLinkedList) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private static LinkedList<Character> convertStringToCharacterLinkedList(String cryptogram) {
        LinkedList<Character> characterLinkedList = new LinkedList<>();
        for (Character ch : cryptogram.toCharArray()) {
            characterLinkedList.add(ch);
        }
        return characterLinkedList;
    }

    private static void findAndRemoveDuplicate(LinkedList<Character> characterLinkedList) {
        while (true) {
            Decoder decoder = Decoder.findDuplicates(characterLinkedList);
            if (!decoder.isDuplicate()) {
                break;
            }
            Decoder.removeDuplicates(decoder, characterLinkedList);
        }
    }
}
