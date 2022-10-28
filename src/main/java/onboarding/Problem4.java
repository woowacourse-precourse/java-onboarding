package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Stream<Character> tokenStream = word.chars().mapToObj(i -> (char) i);
        Stream<Character> reversedStream = tokenStream.map(token -> reverse(token));
        answer = reversedStream.toString();

        return answer;
    }
    static char reverse(char token){
        char result = token;
        if (Character.isAlphabetic(token)){
            result = Character.isLowerCase(token) ? (char)('a' + 'z' - token): (char)('A' + 'Z' - token);
        }

        return result;
    }
}
