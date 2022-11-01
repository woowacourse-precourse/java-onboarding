package service.problem4;

import java.util.List;

public interface Problem4Serviceable {
    String getConvertSentence(String word);
    void convertUpperCase(List<Character> charList, char word);
    void convertLowerCase(List<Character> charList, char word);

}
