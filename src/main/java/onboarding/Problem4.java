package onboarding;

public class Problem4 {
    private static final char[] dictionary={'Z','Y','X','W','V','U'
            ,'T','S','R','Q','P','O','N','M','L','K'
            ,'J','I','H','G','F','E','D','C','B','A'};

    public static String solution(String word) {
        String answer="";

        return answer;
    }

    private static char getWordByDictionary(char character) {
        if(Character.isLowerCase(character)){
            return Character.toLowerCase(dictionary[character-'a']);
        }
        return dictionary[character-'A'];
    }
}
