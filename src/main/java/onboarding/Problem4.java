package onboarding;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {
    public static Character substitude(Character alphabet){
        if(Character.isUpperCase(alphabet)){
            return (char)((int)'A'+(int)'Z'-(int)alphabet);
        }else if(Character.isLowerCase(alphabet)){
            return (char)((int)'a'+(int)'z'-(int)alphabet);
        }else{
            return alphabet;
        }
    }
    public static String solution(String word) {
        Stream<Character> wordStream = word.chars().mapToObj(ch -> (char)ch);
        String answer = wordStream.map(Problem4::substitude)
                            .map(String::valueOf)
                            .collect(Collectors.joining());
        return answer;
    }
}
