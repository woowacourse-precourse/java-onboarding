package onboarding;

import java.util.HashMap;

/*
문제 설명
- 청개구리 사전을 참고해 알파벳을 반대로 변환해야 한다.
- 소문자 -> 소문자, 대문자 -> 대문자를 유지하며 변환해야 한다.
*/

/*
기능 목록
- 청개구리 사전 만들기. (HashMap을 통해 알파벳을 반대로, 소문자, 대문자를 유지하며 변환을 바로 할 수 있도록 구현)
- 사전을 통해 문자열을 변환한다.
*/

public class Problem4 {
    public static String solution(String word) {

        // 청개구리 사전 만들기
        HashMap<Character, Character> frog_dict = new HashMap<>();

        // 아스키 코드표를 이용해 key와 value를 알맞은 값으로 넣어준다.
        for (int i = 65; i < 91; i++) {
            char uppercase_key = (char) i;
            char uppercase_val = (char) (155 - i);
            char lowercase_key = (char) (i + 32);
            char lowercase_val = (char) (187 - i);

            frog_dict.put(uppercase_key, uppercase_val);
            frog_dict.put(lowercase_key, lowercase_val);
        }

        String answer = "";

        // 문자열의 문자 하나씩 반복문을 돌며, 알파벳이라면 변환하여 answer에 concat하고 아니라면 그대로 concat한다.
        for (int i = 0; i < word.length(); i++) {
            char cur_char = word.charAt(i);

            if (frog_dict.containsKey(cur_char)) {
                char converted_char = frog_dict.get(cur_char);

                answer = answer.concat(Character.toString(converted_char));
            }
            else {
                answer = answer.concat(Character.toString(cur_char));
            }
        }

        return answer;
    }
}
