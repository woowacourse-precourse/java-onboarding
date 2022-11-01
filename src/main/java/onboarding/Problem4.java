package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char tempWord : word.toCharArray()) {
            answer += reverseAlphabet(tempWord);
        }

        return answer;
    }

    // 알파벳을 뒤집기 위한 조건을 계산하고 뒤집어서 반환하는 함수
    public static char reverseAlphabet(char alphabet) {
        int ascii;

        if (Character.isUpperCase(alphabet)) { // 대문자 이면 ascii코드 시작은 65
            ascii = 65;
        } else if (Character.isLowerCase(alphabet)) { //소문자 이면 ascii코드 시작은 97
            ascii = 97;
        } else { //대문자와 소문자 이외의 문자이면 그대로 반환 (공백 또는 숫자 또는 특수 문자)
            return alphabet;
        }

        return makeReverse(ascii, (int) alphabet);
    }

    //알파벳을 뒤집는 행동을 하는 함수
    public static char makeReverse(int ascii, int alphabet) {
        // 알파벳 개수가 26개 이므로 a에서 25를 더해 z를 만든 후 현재 알파벳과 a의 차이만큼 빼서 반대로 변환한다.
        return (char) ((ascii + 25) - Math.abs(ascii - (int) alphabet));
    }
}
