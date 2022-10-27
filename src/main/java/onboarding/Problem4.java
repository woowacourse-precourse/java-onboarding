package onboarding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<Character, Character> dict = new HashMap<Character, Character>(){{
            put('A', 'Z');
            put('B', 'Y');
            put('C', 'X');
            put('D', 'W');
            put('E', 'V');
            put('F', 'U');
            put('G', 'T');
            put('H', 'S');
            put('I', 'R');
            put('J', 'Q');
            put('K', 'P');
            put('L', 'O');
            put('M', 'N');
            put('a', 'z');
            put('b', 'y');
            put('c', 'x');
            put('d', 'w');
            put('e', 'v');
            put('f', 'u');
            put('g', 't');
            put('h', 's');
            put('i', 'r');
            put('j', 'q');
            put('k', 'p');
            put('l', 'o');
            put('m', 'n');
        }};

        List<Character> key;
        for (int i = 0; i < word.length(); i++){
            char temp = word.charAt(i);
            // 탐색하는 문자가 A~Z 또는 a~z인지 확인
            if (((int)temp >= 65 && (int)temp <= 90) || ((int)temp >= 97 && (int)temp <= 122)){
                // key에서 탐색하는 문자가 있는 경우
                if (dict.get(temp) != null)
                    answer += dict.get(temp);
                // 없는 경우는 value를 토대로 key 값을 찾음
                else{
                    key = dict.entrySet().stream()
                    .filter(entry -> Objects.equals(entry.getValue(), temp))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
                    // value 또한 중복값 없이 존재하므로 value를 통해 찾은 key 값도 단 1개
                    answer += key.get(0);
                }
            }
            // 그 외의 경우 변환 없이 바로 answer에 추가
            else
                answer += temp;
        }

        return answer;
    }
}
