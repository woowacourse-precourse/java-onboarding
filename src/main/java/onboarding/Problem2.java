package onboarding;

import java.util.LinkedList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer;
        validation(cryptogram);
        answer =  Cryptogram.decodeCryptogram(cryptogram);
        return answer;
    }

    private static void validation(String str) {
        Cryptogram.validationRange(str);
        Cryptogram.validationLowerCase(str);
        Cryptogram.validationContainSpacing(str);
    }
}


class Cryptogram{
    private static final int LOWER_BOUND_LIMIT = 1;
    private static final int UPPER_BOUND_LIMIT = 1000;

    static void validationRange(String cryptogram) {
        if(cryptogram.length() < LOWER_BOUND_LIMIT || cryptogram.length() > UPPER_BOUND_LIMIT){
            throw new IllegalStateException("1이상, 1000 이하인 문자열을 입력해주세요.");
        }
    }
    static void validationLowerCase(String cryptogram){
        char[] charArray = cryptogram.toCharArray();

        for(int index = 0; index < charArray.length; index++){
            if( Character.isUpperCase( charArray[index] ))
                throw new IllegalArgumentException("소문자를 입력해주세요");
        }
    }
    static void validationContainSpacing(String cryptogram) {
        if(cryptogram.contains(" ")){
            throw new IllegalStateException("공백을 포함되어 있습니다");
        }
    }
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