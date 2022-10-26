package onboarding;

/*
 *  🚀 기능 명세
    입력으로 주어진 알파벳의 사전상 반대 알파벳을 반환해주는 메서드 (reverseCharacter)
    * 단, 문자가 알파벳이 아닌 경우(띄어쓰기)에 대한 예외 처리가 필요
    주어진 문자열을 사전상 반전한 결과를 반환할 메서드 (solution)
 */

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for(char character : word.toCharArray()){
            answer += reverseCharacter(character);
        }

        return answer;
    }

    public static char reverseCharacter(char character){
        if('A' <= character && character <= 'Z' ) {
            return (char) ('Z' - character + 'A');
        }
        else if('a' <= character && character <= 'z' ) {
            return (char) ('z' - character + 'a');
        }
        return character;
    }
}
