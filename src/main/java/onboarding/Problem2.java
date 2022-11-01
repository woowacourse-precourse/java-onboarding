package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        List<Character> code = new ArrayList<>();
        code = convert(cryptogram);

        while (code.size()!=removeChar(code).size()) {
            code=removeChar(code);
        }

        StringBuilder sb = new StringBuilder();
        for (char character: code) {
            sb.append(character);
        }

        answer = sb.toString();

        return answer;
    }

    static List<Character> convert(String string) {
        List<Character> chars = IntStream.range(0, string.length())
                .mapToObj(string::charAt)
                .collect(Collectors.toList());

        return chars;
    }

    static List<Character> removeChar(List<Character> list) {
        List<Character> charList = new ArrayList<>();
        charList = list;

        for (int i=0; i<charList.size()-1; i++){
            if (charList.get(i)==charList.get(i+1)){
                charList.remove(i+1);
                charList.remove(i);
                i-=1;
            }
        }

        return charList;
    }
}
