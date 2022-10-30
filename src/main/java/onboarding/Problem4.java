package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        char wordChar = ' ';
        char resultWord = ' ';
        for(int index = 0; index < word.length(); index++){
            wordChar = word.charAt(index);
            resultWord = changeWord(wordChar);
            answer += resultWord;
        }

        return answer;
    }

    public static char changeWord(char spelling){
        char returnSpelling = ' ';

        if (spelling >= 'a' && spelling <= 'z') {
            returnSpelling = (char)((int)'z' - (int)spelling + (int)'a');
        }else if (spelling >= 'A' && spelling <= 'Z'){
            returnSpelling = (char)((int)'Z' - (int)spelling + (int)'A');
        }else if (spelling == ' '){
            returnSpelling = ' ';
        }

        return returnSpelling;
    }
}
