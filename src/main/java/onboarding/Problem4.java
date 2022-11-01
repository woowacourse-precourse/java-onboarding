package onboarding;

public class Problem4 {

    /*
    1. 문자를 입력받는다.
    2. 입력받는 문자를 아래의 내용에 맞춰서 변환한다.
        | A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |
        | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
        | Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |
    3. 입력받은 문자중 대문자는 대문자, 소문자는 소문자로 변환한다.
    * */
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if(letter >= 'a' && letter <='z')
                answer += (char)('a' + 'z' - word.charAt(i));
            else if(letter >= 'A' && letter <='Z'){
                answer += (char)('A'+'Z' - word.charAt(i));
            } else {
                answer += letter;
            }
        }


        return answer;
    }
}
