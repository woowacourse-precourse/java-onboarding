package onboarding.problem2;

import java.util.ArrayList;
import java.util.List;

public class CryptogramDecoder {

    private static final int NOT_DUPLICATED = -1;

    public static String decode(String cryptogram){
        List<Character> cryptogramCharList = TypeConverter.stringToCharacterList(cryptogram);

        List<Character> currentCharList = new ArrayList<>();
        currentCharList.addAll(cryptogramCharList);

        while (true){
            int duplicatedLetterIndex = findDuplicatedLetterIndex(currentCharList);
            if (duplicatedLetterIndex == NOT_DUPLICATED) break;
            removeDuplicatedLetterByIndex(currentCharList, duplicatedLetterIndex);
        }
        return TypeConverter.characterListToString(currentCharList);
    }

    private static int findDuplicatedLetterIndex(List<Character> characterList){
        if (characterList.size() == 0) return NOT_DUPLICATED;

        for (int i=0; i<characterList.size()-1; i++){
            if (characterList.get(i) == characterList.get(i+1)){
                return i;
            }
        }
        return NOT_DUPLICATED;
    }

    private static void removeDuplicatedLetterByIndex(List<Character> characterList, int index){
        char duplicatedLetter = characterList.get(index);
        while (isIndexedCharEqualToCharacter(characterList, index, duplicatedLetter)){
            characterList.remove(index);
        }
    }

    private static boolean isIndexedCharEqualToCharacter(List<Character> characterList, int index, char character){
        return index < characterList.size() && characterList.get(index) == character;
    }
}
