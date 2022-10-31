package onboarding.problem2;

import java.util.ArrayList;
import java.util.List;

public class TypeConverter {

    static public List<Character> stringToCharacterList(String string){
        List<Character> characterList = new ArrayList<>();

        for (char character : string.toCharArray()){
            characterList.add(character);
        }
        return characterList;
    }

    static public String characterListToString(List<Character> characterList){
        StringBuilder sb = new StringBuilder();

        for (char character : characterList){
            sb.append(character);
        }
        return sb.toString();
    }
}
