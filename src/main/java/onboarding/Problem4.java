package onboarding;

public class Problem4 {
    public static String convert(char aCharacter){
        //a-z:97-122 A-Z:65-90 as ascii
        int ascii = (int)aCharacter;

        if(65<=ascii && ascii<=90){
            char newChar = (char)(25-(ascii-65)+65);
            return String.valueOf(newChar);
        }
        if(97<=ascii && ascii<=122){
            char newChar = (char)(25-(ascii-97)+97);
            return String.valueOf(newChar);
        }
        return String.valueOf(aCharacter);
    }
    
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
