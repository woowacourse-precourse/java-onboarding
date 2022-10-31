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

        //단계별로 중복 제거하며 더 이상 중복이 없을 때까지 반복
        while (code.size()!=removeChar(code).size()) {
            code=removeChar(code);
        }

        //list를 String 형태로 변환해 최종 return
        StringBuilder sb = new StringBuilder();
        for (char character: code) {
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

    //중복 제거
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
