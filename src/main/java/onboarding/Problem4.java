package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        List<Character> chars=toCharList(word);
        chars=oppositeChar(chars);
        for(int i=0;i<chars.size();i++){
            answer+=chars.get(i).toString();
        }
        return answer;
    }

    private static List<Character> oppositeChar(List<Character> chars) {
        for(int i=0;i<chars.size();i++){
            if((int)chars.get(i).charValue()>=65&&(int)chars.get(i).charValue()<=90)
                chars.set(i,(char)(155-(int)chars.get(i).charValue()));
            else if((int)chars.get(i).charValue()>=97&&(int)chars.get(i).charValue()<=122)
                chars.set(i,(char)(219-(int)chars.get(i).charValue()));
        }
        return chars;
    }

    private static List<Character> toCharList(String word) {
        List <Character> chars=new ArrayList<>();
        for(int i=0;i<word.length();i++)
            chars.add(word.charAt(i));

        return chars;
    }
}
