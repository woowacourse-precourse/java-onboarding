package service.problem4;

import java.util.ArrayList;
import java.util.List;

public class Problem4ServiceImpl implements Problem4Serviceable{

    public String getConvertSentence(String word){
        List<Character> charList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            char tempWord = word.charAt(i);
            if(Character.isUpperCase(tempWord)) convertUpperCase(charList, tempWord);
            else if(Character.isLowerCase(tempWord)) convertLowerCase(charList, tempWord);
            else charList.add(' ');
        }

        for(Character e: charList) sb.append(e);

        return sb.toString();
    }

    public void convertUpperCase(List<Character> charList,char word){
        int number = 155 - word;
        char convertChar = (char)number;
        charList.add(convertChar);

    }

    public void convertLowerCase(List<Character> charList,char word){
        int number = 219 - word;
        char convertChar = (char)number;
        charList.add(convertChar);
    }
}