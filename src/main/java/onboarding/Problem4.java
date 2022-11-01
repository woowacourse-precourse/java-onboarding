package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        //문자열을 띄어쓰기 포함 알파벳 리스트로 변환
        List<Character> wordCharList = new ArrayList<>();
        wordCharList=convert(word);

        //알파벳 리스트 반대로 변환
        List<Character> answerCharList = new ArrayList<>();
        for (char character: wordCharList) {
            answerCharList.add(reverse(character));
        }

        //list를 String 형태로 변환해 최종 return
        StringBuilder sb = new StringBuilder();
        for (char character: answerCharList) {
            sb.append(character);
        }

        answer = sb.toString();

        return answer;
    }

    //문자열을 알파벳 리스트로 변환 함수
    static List<Character> convert(String string) {
        List<Character> chars = IntStream.range(0, string.length())
                .mapToObj(string::charAt)
                .collect(Collectors.toList());

        return chars;
    }

    //알파벳 반대로 변환 함수
    static char reverse(char character) {
        char reverseChar=' ';
        if (65<= (int)character && (int)character <=90) {
            reverseChar=(char)(155-(int)character);
        } else if (97 <= (int)character && (int)character <=122) {
            reverseChar=(char)(219-(int)character);
        } else {
            reverseChar = character;
        }
        return reverseChar;
    }


}
