package onboarding;

public class Problem4 {
    private static final char[] dictionary={'Z','Y','X','W','V','U'
            ,'T','S','R','Q','P','O','N','M','L','K'
            ,'J','I','H','G','F','E','D','C','B','A'};

    public static String solution(String word) {
        return createWordByDictionary(word);
    }

    private static String createWordByDictionary(String word) {
        StringBuilder answer=new StringBuilder();

        for(int i=0;i<word.length();i++){
            char character=word.charAt(i);

            if(Character.isAlphabetic(character)){
                answer.append(convertWordByDictionary(character));
            }else{
                answer.append(character);
            }
        }
        return answer.toString();
    }

    private static char convertWordByDictionary(char character) {
        if(Character.isLowerCase(character)){
            return Character.toLowerCase(dictionary[character-'a']);
        }
        return dictionary[character-'A'];
    }
}
