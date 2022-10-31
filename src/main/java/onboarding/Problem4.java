package onboarding;

public class Problem4 {

    /*
    아스키 코드 값을 이용해서 문제를 해결했습니다.
    입력으로 들어오는 문자열에 포함된 문자는 총 3가지 타입이 있습니다.
    whitespace, 소문자, 대문자가 그것입니다.
    각 경우에 대하여 그에 맞는 변환을 수행해 정답 문자열에 추가하여 리턴했습니다.
    */
    public static String solution(String word) {
        String answer = "";
        char[] letters = word.toCharArray();
        int strLen = word.length();

        for (int i = 0; i < strLen; i++) {
            if (letters[i] == ' ')
                answer += " ";

            else if (Character.isUpperCase(letters[i]))
                answer += (char) (155 - (int) letters[i]);

            else
                answer += (char) (219 - (int) letters[i]);
        }

        return answer;
    }
}
