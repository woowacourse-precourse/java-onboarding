package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
    // 문자열 대문자,소문자,공백, 특수기호, 확인
    public static String checkLetter(char letter){
        if (Character.isUpperCase(letter)) return "A";
        if (Character.isLowerCase(letter)) return "a";
        else return "etc";

    }

    // 대문자 변환
    public static char translateUpperCase(char letter, String dictionary, String frogDictionary){
        int index = -1;
        index = dictionary.indexOf(letter);
        return frogDictionary.charAt(index);

    }
    // 소문자 변환
    public static char translateLowerCase(char letter, String dictionary, String frogDictionary){
        int index = -1;
        index = dictionary.indexOf(letter);
        return frogDictionary.charAt(index);
    }


}
