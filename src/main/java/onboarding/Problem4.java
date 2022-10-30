package onboarding;

public class Problem4 {
    public static char reverse(char character,int start,int end){
        // Use ASCII to swap the alphabet as guided
        if ((int) character >= start && (int) character <= end) {
            character = (char) (end - (int) character + start);
        }
        return character;
    }
    public static String solution(String word) {
        String answer = "";
        for (int i=0; i<word.length();i++) {
            // get each character of the word
            char character = word.charAt(i);
            // Check if each character is a upper case of Alphabet then swap
            character=reverse(character,65,90);
            // Check if each character is a lower case of Alphabet then swap
            character=reverse(character,97,122);
            answer += character;
        }
        return answer;
    }
}
