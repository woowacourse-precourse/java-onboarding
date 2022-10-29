package onboarding;

public class Problem4 {

    static boolean isUpperCase(char character){
        return (character >= 'A' && character <= 'Z');
    }
    static boolean isLowerCase(char character){
        return (character >= 'a' && character <= 'z');
    }
    static boolean isAlphabet(char character){
        return (isUpperCase(character)||isLowerCase(character));
    }

    static char changeCharacterToReverse(char character){
        return isUpperCase(character) ? (char)('Z'-character+'A') : (char)('z'-character+'a');
    }

    static String getAnswer(String word){
        String answer = "";
        for (int index = 0;index<word.length();index++){
            answer += (isAlphabet(word.charAt(index))) ?
                    String.valueOf(changeCharacterToReverse(word.charAt(index))) :
                    String.valueOf(word.charAt(index));
        }
        return answer;
    }
    public static String solution(String word) {
        String answer = getAnswer(word);
        return answer;
    }
}
