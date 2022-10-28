package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i=0;i<word.length();i++){
            answer+=conversion(word.charAt(i));
        }
        return answer;
    }

    /**
     * 문자 변환 함수 구현
     */
    private static char conversion(char character){
        if (Character.isUpperCase(character))
            return (char)('Z' - (character - 'A'));
        else if (Character.isLowerCase(character))
            return (char)('z' - (character - 'a'));
        else
            return character;
    }
}
