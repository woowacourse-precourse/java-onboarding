package onboarding;

import java.util.HashMap;
class Convert{
    private static HashMap<Character, Character> alphabets;
    private StringBuilder stringBuilder;
    private String word;
    public Convert(String word){
        this.word = word;
        this.stringBuilder = new StringBuilder();
    }
    public static void alphabetInit(){
        alphabets = new HashMap<>();
        for(char key='a'; key<='z'; key++) {
            char invKey = (char) ('z' - key + 'a');
            alphabets.put(key, invKey);
            alphabets.put(Character.toUpperCase(key), Character.toUpperCase(invKey));
        }
        alphabets.put(' ',' ');
    }
    public String convertAlphabets() {
        for (int i = 0; i < this.word.length(); i++) {
            this.stringBuilder.append(alphabets.get(this.word.charAt(i)));
        }
        return this.stringBuilder.toString();
    }

}
public class Problem4 {

    public static String solution(String word) {
        Convert.alphabetInit();
        Convert convert = new Convert(word);
        String convertedString = convert.convertAlphabets();
        return convertedString;
    }
}
