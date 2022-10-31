package onboarding;

public class Problem4 {

    public static String solution(String word) {
        String answer = "";
        answer = getAnswer(word); // 청개구리가 하는 말
        return answer;
    }

    // 청개구리가 하는 말 전체를 반환하는 함수
    private static String getAnswer(String word) {
        StringBuilder frogString = new StringBuilder(); // 청개구리가 하는 말 저장

        // 엄마 말씀 word에서 한 글자씩(w) 차례대로 확인
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i); // 엄마의 말씀 한 글자
            frogString.append(getFrogWord(w)); // 엄마의 말씀 한 글자씩을 청개구리가 하는 말로 변환
        }

        return frogString.toString();
    }

    // 엄마의 말씀 한 글자를 청개구리가 하는 말로 변환하여 반환하는 함수
    private static char getFrogWord(char momWord) {
        boolean isUpperCase = false; // 현재 확인하는 글자가 대문자인지 확인하는 변수 (대문자라면 true / 대문자가 아니라면 false)

        // 현재 확인하는 글자가 대문자라면 소문자로 변환, isUpperCase = true
        if (Character.isUpperCase(momWord)) {
            momWord = Character.toLowerCase(momWord);
            isUpperCase = true;
        }

        // 현재 확인하는 글자가 알파벳이 아닌 경우 그대로 반환
        if (momWord < 'a' || momWord > 'z') {
            return momWord;
        }

        // 현재 확인하는 글자가 알파벳인 경우
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String frog = "zyxwvutsrqponmlkjihgfedcba";

        int alphaIndex = alpha.indexOf(momWord);
        char frogWord = frog.toCharArray()[alphaIndex];
        // -> 청개구리의 말 글자 하나 = 엄마의 말씀 한 글자를 alpha에서의 index 값으로 frog를 접근한 곳의 글자

        // 현재 확인하는 엄마의 말씀 한 글자가 대문자였었다면 frogWord를 대문자로 변환
        if (isUpperCase) {
            frogWord = Character.toUpperCase(frogWord);
        }

        return frogWord;
    }

}
