package onboarding;

import java.util.function.Function;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        if(!checkValidation(word)){
            return null;
        }
        answer = convertStringByDict(word);
        return answer;
    }

    private static boolean checkValidation(String word){
        if(1 <= word.length() || word.length()<=1000){
            return true;
        }
        return false;
    }

    private static String convertStringByDict(String word){
        Stream<Character> charStream = word.chars().mapToObj(i -> (char)i);
        String convertedString = charStream.map(getFilter())
                .collect(()-> new StringBuffer(), (c, e)->c.append(e), (c1,c2)-> c1.append(c2))
                .toString();
        return convertedString;
    }

    private static Function<Character, Character> getFilter(){
        return (ch) -> {
            if (needConvert(ch)) {
                return getConvertedChar(ch);
            }
            return ch;
        };
    }

    private static boolean needConvert(char ch){
        if('a'< ch && ch < 'z'){
            return true;
        }
        if('A'< ch && ch < 'Z'){
            return true;
        }
        return false;
    }

    private static char getConvertedChar(char ch){
        if('a'< ch && ch < 'z'){
            return (char)('a'+('z' - ch));
        }
        if('A'< ch && ch < 'Z'){
            return (char)('A'+('Z' - ch));
        }
        return ' ';
    }
}
