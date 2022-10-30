package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";

        // 엄마 말씀 word에서 한 글자씩 차례대로 확인
        // 청개구리가 하는 말은 frogString에 저장

        // 1. 해당 글자가 알파벳이 아니라면 그대로 frogString에 저장

        // 2. 해당 글자가 알파벳일 경우
        // String alpha = "abcdefghijklmnopqrstuvwxyz";
        // String frog = "zyxwvutsrqponmlkjihgfedcba";
        // -> 청개구리의 말 글자 = 엄마의 말 글자를 alpha에서의 index 값으로 frog를 접근한 곳의 글자

        // 3. 엄마의 말 글자가 대문자일 경우 소문자로 먼저 변환한 후 frog의 글자를 찾고, 해당 frog 글자를 대문자로 변환하여 frogString에 저장

        return answer;
    }

}
