package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /**
     * 알파벳의 대문자는 소문자로 소문자는 대문자로 바꾸는 기능
     */
    public static Character changeAlphabetCase(char c){
        if(Character.isLowerCase(c)){
            return Character.toUpperCase(c);
        }else{
            return Character.toLowerCase(c);
        }
    }

    /**
     * 알파벳을 거꾸로 반환
     */
    public static Character reverseAlphabet(char c){
        if(Character.isLowerCase(c)){
            return ((char) ('z' + 'a' - c));
        }else{
            return ((char) ('Z' + 'A' - c));
        }
    }
}
