package onboarding;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        Map<Character, Character> convert_dict = make_convert_dict();

        for (char c : word.toCharArray()) {

            if (convert_dict.get(c) != null){
                answer += convert_dict.get(c);

            } else {
                answer += c;
            }
        }
        return answer;
    }

    public static Map<Character, Character> make_convert_dict(){
        Map<Character, Character> convert_dict;

        Map<Character, Character> uppercase_convert_dict = match_ascii_between(65, 90);
        Map<Character, Character> lowercase_convert_dict = match_ascii_between(97, 122);

        uppercase_convert_dict.putAll(lowercase_convert_dict);
        convert_dict = uppercase_convert_dict;

        return convert_dict;
    }

    public static Map<Character, Character> match_ascii_between(int start_ascii, int end_ascii){
        Map<Character, Character> convert_dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            Character start_alpha = (char)start_ascii;
            Character end_alpha = (char)end_ascii;

            convert_dict.put(start_alpha, end_alpha);
            convert_dict.put(end_alpha, start_alpha);

            start_ascii += 1;
            end_ascii -= 1;
        }

        return convert_dict;
    }


}