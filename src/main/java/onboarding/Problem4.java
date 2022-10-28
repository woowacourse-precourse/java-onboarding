package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    // String -> Char[] 로
    private static char[] changeToChar(String word) {
        char[] wordChar = word.toCharArray();

        return wordChar;
    }

    // 대문자인지, 소문자인지 판단하는 함수
    private static char checkUpper(char input) throws IllegalArgumentException {
        // 대문자일 경우
        if(input >= 65 && input <= 90 ) {
            return 'A';
        }
        // 소문자일 경우
        else if(input >= 97 && input <= 122) {
            return 'a';
        }
        else if (input == ' ') {
            return ' ';
        }
        // 대문자도, 소문자도, 공백도 아닐 경우
        throw new IllegalArgumentException("알파벳 외의 문자는 입력할 수 없습니다.");
    }

    // 문자를 규칙에 맞게 변환하는 함수
    private static char converseResult(char input) {
        int minus = 0;
        // 대문자일 경우
        if(checkUpper(input) == 'A') {
            // input 에서 대문자 시작 아스키 코드를 빼고,
            minus = input - 'A';
            // 그 결과를 원래 input 에 빼면 반대 기호가 나옴
            input = (char) ('Z' - minus);

            return input;
        }
        // 소문자일 경우
        else if(checkUpper(input) == 'a') {
            // input 에서 소문자 시작 아스키 코드를 빼고,
            minus = input - 'a';
            // 그 결과를 원래 input 에 빼면 반대 기호가 나옴
            input = (char) ('z' - minus);

            return input;
        }
        // 공백일 경우 리턴
        return input;
    }
}
