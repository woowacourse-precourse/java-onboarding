package onboarding;

public class Problem4 {
    static boolean isUpperCharacter;

    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /*
    * 주어진 문자의 알파벳 여부를 반환
    *
    * @return boolean
    * */
    private static boolean isAlphabet(char character) {
        return (character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z');
    }

    /*
    * 주어진 문자의 대문자 여부를 확인해 isUpperCharacter 값 설정
    * isUpperCharacter 초기값은 false
    *
    * @return void
    * */
    private static void setIsUpperCharacter(char character) {
        if (Character.isUpperCase(character)) {
            isUpperCharacter = true;
        }
    }
}
