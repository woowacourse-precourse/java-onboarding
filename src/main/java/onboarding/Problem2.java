package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        answer =  Cryptogram.decodeCryptogram(cryptogram);
        return answer;
    }
}
class Cryptogram{
    private static boolean isPresent(LinkedList<Character> list){
        if(list.isEmpty()){
            return false;
        }
        return true;
    }
    static String decodeCryptogram(String cryptogram) {
        LinkedList<Character> characters = getCharacterArrayList(cryptogram);
        int listSize = characters.size() - 1;
        while (listSize != 0) {
            if (deleteDuplicatedCryptogram(characters, listSize) && isPresent(characters)) {
                listSize = characters.size() - 1;
            } else {
                listSize--;
            }
        }
        StringBuilder bld = new StringBuilder();
        for (int j = 0; j <characters.size(); j++) {
            bld.append(characters.get(j));
        }
        return bld.toString();
    }

    private static LinkedList<Character> getCharacterArrayList(String cryptogram) {
        LinkedList<Character> characters = new LinkedList<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            characters.add(cryptogram.charAt(i));
        }
        return characters;
    }

    private static boolean deleteDuplicatedCryptogram(LinkedList<Character> characters, int i) {
        if (characters.get(i).equals(characters.get(i - 1)) && i >= 1){
            characters.remove(i);
            characters.remove(i - 1);
            return true;
        }
        return false;
    }

}