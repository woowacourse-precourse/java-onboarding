package onboarding;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem4 {

    public static void main(String[] args) {
        String word = "I LoVe you";
        System.out.println(solution(word));
    }

    public static String solution(String word) {
        String answer = "";
        String temp = word.toUpperCase();
        Character[][] dictionary = {{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                                     'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'},
                                    {'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N',
                                     'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'}};

        Character[] charArr = temp.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new);

        for (int i = 0; i < charArr.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (charArr[i] == dictionary[0][j]) {
                    charArr[i] = dictionary[1][j];
                    if (!Character.isUpperCase(word.charAt(i))) {
                        charArr[i] = Character.toLowerCase(charArr[i]);
                    }
                    break;
                }
            }
        }
        Stream<Character> charStream = Arrays.stream(charArr);
        answer = charStream.map(String::valueOf).collect(Collectors.joining());
        return answer;
    }
}
